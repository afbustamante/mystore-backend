package net.andresbustamante.mystore.web.controllers.v1;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_IMPLEMENTED;

import java.net.URI;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.andresbustamante.mystore.api.exceptions.FunctionalException;
import net.andresbustamante.mystore.api.model.CustomerCreationDto;
import net.andresbustamante.mystore.api.model.CustomerDto;
import net.andresbustamante.mystore.api.model.CustomerSearchCriteria;
import net.andresbustamante.mystore.api.model.Page;
import net.andresbustamante.mystore.api.model.PagingRequest;
import net.andresbustamante.mystore.api.services.CustomersManagementService;
import net.andresbustamante.mystore.api.services.CustomersSearchService;
import net.andresbustamante.mystore.web.dto.v1.Customer;
import net.andresbustamante.mystore.web.dto.v1.CustomerForm;
import net.andresbustamante.mystore.web.dto.v1.CustomerPage;
import net.andresbustamante.mystore.web.mappers.v1.CustomerDtoMapper;

@RestController
@RequestMapping("/api/v1")
public class CustomersController extends AbstractController implements CustomersApi {

    private final CustomersSearchService customersSearchService;
    private final CustomersManagementService customersManagementService;
    private final CustomerDtoMapper customerDtoMapper;

    public CustomersController(
            final ObjectMapper objectMapper, final HttpServletRequest request,
            final CustomersSearchService customersSearchService,
            final CustomersManagementService customersManagementService, final CustomerDtoMapper customerDtoMapper) {
        super(objectMapper, request);

        this.customersSearchService = customersSearchService;
        this.customersManagementService = customersManagementService;
        this.customerDtoMapper = customerDtoMapper;
    }

    @Override
    public ResponseEntity<Void> createCustomer(final CustomerForm body) {
        CustomerCreationDto customer = new CustomerCreationDto(
                body.getFirstName(), body.getLastName(), body.getEmail(), body.getPhoneNumber(),
                body.getUsername(), body.getPassword(), body.getAddressLine1(), body.getAddressLine2(),
                body.getPostalCode(), body.getCityId()
        );

        try {
            int id = customersManagementService.createCustomer(customer);

            return ResponseEntity.created(URI.create(String.format("/api/v1/customers/%d", id))).build();
        } catch (FunctionalException e) {
            throw new ResponseStatusException(CONFLICT, e.getMessage(), e);
        }
    }

    @Override
    public ResponseEntity<Customer> findCustomer(final Integer id) {
        // TODO Implement this method
        throw new ResponseStatusException(NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<CustomerPage> findCustomers(final Integer pageNumber, final Integer pageSize) {
        CustomerSearchCriteria criteria = CustomerSearchCriteria.builder()
                .country("France")
                .build();
        Page<CustomerDto> customers = customersSearchService.findCustomers(criteria,
                PagingRequest.of(pageNumber, pageSize));

        return ResponseEntity.ok(customerDtoMapper.map(customers));
    }
}
