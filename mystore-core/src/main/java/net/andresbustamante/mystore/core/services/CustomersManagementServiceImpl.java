package net.andresbustamante.mystore.core.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.andresbustamante.mystore.api.model.Customer;
import net.andresbustamante.mystore.api.services.CustomersManagementService;
import net.andresbustamante.mystore.core.dao.CustomerDao;

@Slf4j
@Service
public class CustomersManagementServiceImpl implements CustomersManagementService {

    private final CustomerDao customerDao;

    public CustomersManagementServiceImpl(final CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    @Transactional
    public int createCustomer(final Customer customer) {
        net.andresbustamante.mystore.core.entities.Customer c = new net.andresbustamante.mystore.core.entities.Customer();
        c.setFirstName(customer.getFirstName());
        c.setLastName(customer.getLastName());
        c.setEmail(customer.getEmail());

        c = customerDao.save(c);

        log.info("New customer created for {} with the ID {}", customer.getEmail(), c.getId());

        return c.getId();
    }
}
