package net.andresbustamante.mystore.core.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import net.andresbustamante.mystore.core.config.CoreDaoTestConfig;
import net.andresbustamante.mystore.core.entities.Customer;

@DataJpaTest
@ContextConfiguration(classes = CoreDaoTestConfig.class)
class CustomerDaoIT {

    @Autowired
    private CustomerDao customerDao;

    @Test
    void testFindAllByCountry() {
        Collection<Customer> customers = customerDao.findAllByCountry("UK");

        assertNotNull(customers);
    }
}
