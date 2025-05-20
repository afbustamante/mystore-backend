package net.andresbustamante.mystore.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.andresbustamante.mystore.core.entities.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

    @Query("""
            from Customer c
            inner join c.address a
            inner join a.city ci
            inner join ci.country co
            where co.name = :country
        """)
    List<Customer> findAllByCountry(@Param("country") String country);
}
