package net.andresbustamante.mystore.jpa.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;

import net.andresbustamante.mystore.jpa.config.CoreDaoTestConfig;
import net.andresbustamante.mystore.jpa.entities.CustomerEntity;

@DataJpaTest
@ContextConfiguration(classes = CoreDaoTestConfig.class)
class CustomerDaoIT {

    @Autowired
    private CustomerDao customerDao;

    @Test
    void testFindAllByCountry() {
        Collection<CustomerEntity> customers = customerDao.findAllByCountry("UK");

        assertNotNull(customers);
    }

    @Test
    void testFindAllByCountryWithPages() {
        Page<CustomerEntity> customers = customerDao.findAllByCountry("UK", PageRequest.of(0, 10));

        assertNotNull(customers);
    }
}
