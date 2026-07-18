package net.andresbustamante.mystore.web.controllers.v1;

import static org.springframework.http.HttpStatus.*;

import java.net.URI;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.andresbustamante.mystore.api.exceptions.ApplicationException;
import net.andresbustamante.mystore.api.exceptions.FunctionalException;
import net.andresbustamante.mystore.api.exceptions.ObjectNotFoundException;
import net.andresbustamante.mystore.api.exceptions.SecurityException;
import net.andresbustamante.mystore.api.model.CustomerCreation;
import net.andresbustamante.mystore.api.model.Customer;
import net.andresbustamante.mystore.api.model.CustomerSearchCriteria;
import net.andresbustamante.mystore.api.model.CustomerUpdate;
import net.andresbustamante.mystore.api.util.Page;
import net.andresbustamante.mystore.api.util.PagingRequest;
import net.andresbustamante.mystore.api.services.CustomersManagementService;
import net.andresbustamante.mystore.api.services.CustomersSearchService;
import net.andresbustamante.mystore.web.dto.v1.CustomerDto;
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
        CustomerCreation customer = new CustomerCreation(
                body.getFirstName(), body.getLastName(), body.getEmail(), body.getPhoneNumber(),
                body.getUsername(), body.getPassword(), body.getAddress().getLine1(), body.getAddress().getLine2(),
                body.getAddress().getPostalCode(), body.getAddress().getCityId()
        );

        try {
            int id = customersManagementService.createCustomer(customer);

            return ResponseEntity.created(URI.create(String.format("/api/v1/customers/%d", id))).build();
        } catch (FunctionalException e) {
            throw new ResponseStatusException(CONFLICT, e.getMessage(), e);
        } catch (ApplicationException e) {
            throw new ResponseStatusException(INTERNAL_SERVER_ERROR, "Error while creating the new customer", e);
        }
    }

    @Override
    public ResponseEntity<CustomerForm> updateCustomer(final Integer id, final CustomerForm body) {
        CustomerUpdate customer = new CustomerUpdate(
                body.getFirstName(), body.getLastName(), body.getEmail(), body.getPhoneNumber()
        );

        try {
            customersManagementService.updateCustomer(id, customer);

            return ResponseEntity.accepted().build();
        } catch (SecurityException e) {
            throw new ResponseStatusException(FORBIDDEN, "Not allowed to update this customer", e);
        } catch (ObjectNotFoundException e) {
            throw new ResponseStatusException(NOT_FOUND, "Customer not found", e);
        } catch (FunctionalException e) {
            throw new ResponseStatusException(CONFLICT, "Impossible to update the customer", e);
        } catch (ApplicationException e) {
            throw new ResponseStatusException(INTERNAL_SERVER_ERROR, "Error while updating the customer", e);
        }
    }

    @Override
    public ResponseEntity<CustomerDto> findCustomer(final Integer id) {
        // TODO Implement this method
        throw new ResponseStatusException(NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<CustomerPage> findCustomers(final Integer pageNumber, final Integer pageSize) {
        CustomerSearchCriteria criteria = CustomerSearchCriteria.builder()
                .country("France")
                .build();
        Page<Customer> customers = customersSearchService.findCustomers(criteria,
                PagingRequest.of(pageNumber, pageSize));

        return ResponseEntity.ok(customerDtoMapper.map(customers));
    }

    @Override
    public ResponseEntity<CustomerDto> deactivateCustomer(final Integer customerId) {
        try {
            customersManagementService.deactivateCustomer(customerId);
            return ResponseEntity.noContent().build();
        } catch (SecurityException e) {
            throw new ResponseStatusException(FORBIDDEN, "Not allowed to deactivate this customer", e);
        } catch (ObjectNotFoundException e) {
            throw new ResponseStatusException(NOT_FOUND, "Customer not found", e);
        } catch (FunctionalException e) {
            throw new ResponseStatusException(CONFLICT, "Impossible to deactivate this customer", e);
        } catch (ApplicationException e) {
            throw new ResponseStatusException(INTERNAL_SERVER_ERROR, "Error while deactivating this user", e);
        }
    }
}
