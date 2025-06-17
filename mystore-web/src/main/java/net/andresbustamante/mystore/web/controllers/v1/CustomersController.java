package net.andresbustamante.mystore.web.controllers.v1;

import java.net.URI;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.andresbustamante.mystore.api.model.Customer;
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
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());

        int id = customersManagementService.createCustomer(customer);

        return ResponseEntity.created(URI.create(String.format("/api/v1/customers/%d", id))).build();
    }
}
