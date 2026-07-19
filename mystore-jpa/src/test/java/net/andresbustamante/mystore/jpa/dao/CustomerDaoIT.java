package net.andresbustamante.mystore.jpa.dao;

import static com.github.springtestdbunit.annotation.DatabaseOperation.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

import net.andresbustamante.mystore.jpa.config.CoreDaoTestConfig;
import net.andresbustamante.mystore.jpa.entities.CustomerEntity;

@ContextConfiguration(classes = CoreDaoTestConfig.class)
@DatabaseSetup(value = "classpath:datasets/customers.csv", type = CLEAN_INSERT)
@DatabaseTearDown(value = "classpath:datasets/customers.csv", type = DELETE)
class CustomerDaoIT extends DaoIntegrationTest {

    @Autowired
    private CustomerDao customerDao;

    @Test
    void testFindAllByCountry() {
        Collection<CustomerEntity> customers = customerDao.findAllByCountry("UK");

        assertNotNull(customers);
        assertEquals(13, customers.size());
    }

    @Test
    void testFindAllByCountryWithPages() {
        Page<CustomerEntity> customers = customerDao.findAllByCountry("UK", PageRequest.of(0, 10));

        assertNotNull(customers);
        assertEquals(13, customers.getTotalElements());
    }
}
