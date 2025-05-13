package net.andresbustamante.mystore.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.andresbustamante.mystore.core.entities.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

    List<Customer> findAllByCountry(String country);
}
