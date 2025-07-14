package net.andresbustamante.mystore.api.services;

import java.util.Collection;

import net.andresbustamante.mystore.api.model.CustomerDto;
import net.andresbustamante.mystore.api.model.CustomerSearchCriteria;
import net.andresbustamante.mystore.api.model.Page;
import net.andresbustamante.mystore.api.model.PagingRequest;

public interface CustomersSearchService {

    Collection<CustomerDto> findCustomers(CustomerSearchCriteria criteria);

    Page<CustomerDto> findCustomers(CustomerSearchCriteria criteria, PagingRequest pagingRequest);
}
