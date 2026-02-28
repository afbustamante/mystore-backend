package net.andresbustamante.mystore.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.andresbustamante.mystore.jpa.entities.AddressEntity;

public interface AddressDao extends JpaRepository<AddressEntity, Integer> {
}
