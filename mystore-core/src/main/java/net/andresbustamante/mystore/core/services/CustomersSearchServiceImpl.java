package net.andresbustamante.mystore.core.services;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.andresbustamante.mystore.api.model.Customer;
import net.andresbustamante.mystore.api.model.CustomerSearchCriteria;
import net.andresbustamante.mystore.api.util.Page;
import net.andresbustamante.mystore.api.util.PagingRequest;
import net.andresbustamante.mystore.api.services.CustomersSearchService;
import net.andresbustamante.mystore.jpa.dao.CustomerDao;
import net.andresbustamante.mystore.jpa.entities.CustomerEntity;
import net.andresbustamante.mystore.jpa.mappers.CustomerEntityMapper;

@Service
@Transactional(readOnly = true)
public class CustomersSearchServiceImpl implements CustomersSearchService {

    private final CustomerDao customerDao;
    private final CustomerEntityMapper customerEntityMapper;

    public CustomersSearchServiceImpl(final CustomerDao customerDao, final CustomerEntityMapper customerEntityMapper) {
        this.customerDao = customerDao;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public Collection<Customer> findCustomers(final CustomerSearchCriteria criteria) {
        List<CustomerEntity> customers = customerDao.findAllByCountry(criteria.getCountry());
        return customerEntityMapper.map(customers);
    }

    @Override
    public Page<Customer> findCustomers(final CustomerSearchCriteria criteria, PagingRequest pagingRequest) {
        var customers = customerDao.findAllByCountry(criteria.getCountry(),
                PageRequest.of(pagingRequest.pageNumber(), pagingRequest.pageSize(), Sort.by("id").descending()));
        return customerEntityMapper.map(customers);
    }
}
