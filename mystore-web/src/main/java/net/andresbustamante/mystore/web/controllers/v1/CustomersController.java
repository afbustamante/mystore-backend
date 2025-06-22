package net.andresbustamante.mystore.web.controllers.v1;

import static org.springframework.http.HttpStatus.*;

import java.net.URI;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import net.andresbustamante.mystore.api.exceptions.FunctionalException;
import net.andresbustamante.mystore.api.model.Customer;
import net.andresbustamante.mystore.api.model.CustomerCreationDto;
import net.andresbustamante.mystore.api.model.CustomerSearchCriteria;
import net.andresbustamante.mystore.api.services.CustomersManagementService;
import net.andresbustamante.mystore.api.services.CustomersSearchService;
import net.andresbustamante.mystore.web.dto.v1.CustomerDto;
import net.andresbustamante.mystore.web.mappers.v1.CustomerDtoMapper;

@RestController
@RequestMapping("/api/v1")
public class CustomersController {

    private final CustomersSearchService customersSearchService;
    private final CustomersManagementService customersManagementService;
    private final CustomerDtoMapper customerDtoMapper;

    public CustomersController(final CustomersSearchService customersSearchService,
            final CustomersManagementService customersManagementService, final CustomerDtoMapper customerDtoMapper) {
        this.customersSearchService = customersSearchService;
        this.customersManagementService = customersManagementService;
        this.customerDtoMapper = customerDtoMapper;
    }

    @GetMapping("/customers")
    public ResponseEntity<Collection<CustomerDto>> findCustomers() {
        CustomerSearchCriteria criteria = CustomerSearchCriteria.builder().country("France").build();
        Collection<Customer> customers = customersSearchService.findCustomers(criteria);
        return ResponseEntity.ok(customerDtoMapper.map(customers));
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody net.andresbustamante.mystore.web.dto.v1.CustomerCreationDto dto) {
        CustomerCreationDto customer = new CustomerCreationDto(
                dto.getFirstName(), dto.getLastName(), dto.getEmail(), dto.getPhoneNumber(),
                dto.getUsername(), dto.getPassword(), dto.getAddressLine1(), dto.getAddressLine2(), dto.getPostalCode(), dto.getCityId()
        );

        try {
            int id = customersManagementService.createCustomer(customer);

            return ResponseEntity.created(URI.create(String.format("/api/v1/customers/%d", id))).build();
        } catch (FunctionalException e) {
            throw new ResponseStatusException(CONFLICT, e.getMessage(), e);
        }
    }
}
