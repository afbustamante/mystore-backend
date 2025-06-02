package net.andresbustamante.mystore.web.controllers.v1;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.andresbustamante.mystore.api.model.Customer;
import net.andresbustamante.mystore.api.model.CustomerSearchCriteria;
import net.andresbustamante.mystore.api.services.CustomersSearchService;
import net.andresbustamante.mystore.web.dto.v1.CustomerDto;
import net.andresbustamante.mystore.web.mappers.v1.CustomerDtoMapper;

@RestController
@RequestMapping("/api/v1")
public class CustomersController {

    private final CustomersSearchService customersSearchService;
    private final CustomerDtoMapper customerDtoMapper;

    public CustomersController(final CustomersSearchService customersSearchService, final CustomerDtoMapper customerDtoMapper) {
        this.customersSearchService = customersSearchService;
        this.customerDtoMapper = customerDtoMapper;
    }

    @GetMapping("/customers")
    public ResponseEntity<Collection<CustomerDto>> findCustomers() {
        CustomerSearchCriteria criteria = CustomerSearchCriteria.builder().country("France").build();
        Collection<Customer> customers = customersSearchService.findCustomers(criteria);
        return ResponseEntity.ok(customerDtoMapper.map(customers));
    }
}
