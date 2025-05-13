package net.andresbustamante.mystore.core.services;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.andresbustamante.mystore.api.model.Customer;
import net.andresbustamante.mystore.api.model.CustomerSearchCriteria;
import net.andresbustamante.mystore.api.services.CustomersSearchService;
import net.andresbustamante.mystore.core.dao.CustomerDao;

@Service
@Transactional(readOnly = true)
public class CustomersSearchServiceImpl implements CustomersSearchService {

    private final CustomerDao customerDao;

    public CustomersSearchServiceImpl(final CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public Collection<Customer> findCustomers(final CustomerSearchCriteria criteria) {
        return customerDao.findAllByCountry(criteria.getCountry()).stream().map(customer -> {
            Customer cust = new Customer();
            cust.setFirstName(customer.getFirstName());
            cust.setLastName(customer.getLastName());
            cust.setEmail(customer.getEmail());
            cust.setUsername(customer.getUsername());
            return cust;
        }).toList();
    }
}
