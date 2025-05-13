package net.andresbustamante.mystore.api.services;

import java.util.Collection;

import net.andresbustamante.mystore.api.model.Customer;
import net.andresbustamante.mystore.api.model.CustomerSearchCriteria;

public interface CustomersSearchService {

    Collection<Customer> findCustomers(CustomerSearchCriteria criteria);
}
