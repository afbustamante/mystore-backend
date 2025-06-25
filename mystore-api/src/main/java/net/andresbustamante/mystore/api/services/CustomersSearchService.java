package net.andresbustamante.mystore.api.services;

import java.util.Collection;

import net.andresbustamante.mystore.api.model.CustomerDto;
import net.andresbustamante.mystore.api.model.CustomerSearchCriteria;

public interface CustomersSearchService {

    Collection<CustomerDto> findCustomers(CustomerSearchCriteria criteria);
}
