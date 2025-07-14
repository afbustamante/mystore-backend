package net.andresbustamante.mystore.core.services;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.andresbustamante.mystore.api.model.CustomerDto;
import net.andresbustamante.mystore.api.model.CustomerSearchCriteria;
import net.andresbustamante.mystore.api.model.Page;
import net.andresbustamante.mystore.api.model.PagingRequest;
import net.andresbustamante.mystore.api.services.CustomersSearchService;
import net.andresbustamante.mystore.core.dao.CustomerDao;
import net.andresbustamante.mystore.core.entities.Customer;
import net.andresbustamante.mystore.core.mappers.CustomerMapper;

@Service
@Transactional(readOnly = true)
public class CustomersSearchServiceImpl implements CustomersSearchService {

    private final CustomerDao customerDao;
    private final CustomerMapper customerMapper;

    public CustomersSearchServiceImpl(final CustomerDao customerDao, final CustomerMapper customerMapper) {
        this.customerDao = customerDao;
        this.customerMapper = customerMapper;
    }

    @Override
    public Collection<CustomerDto> findCustomers(final CustomerSearchCriteria criteria) {
        List<Customer> customers = customerDao.findAllByCountry(criteria.getCountry());
        return customerMapper.map(customers);
    }

    @Override
    public Page<CustomerDto> findCustomers(final CustomerSearchCriteria criteria, PagingRequest pagingRequest) {
        var customers = customerDao.findAllByCountry(criteria.getCountry(),
                PageRequest.of(pagingRequest.pageNumber(), pagingRequest.pageSize()));
        return customerMapper.map(customers);
    }
}
