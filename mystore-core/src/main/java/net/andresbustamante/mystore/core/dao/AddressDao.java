package net.andresbustamante.mystore.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.andresbustamante.mystore.core.entities.Address;

public interface AddressDao extends JpaRepository<Address, Integer> {
}
