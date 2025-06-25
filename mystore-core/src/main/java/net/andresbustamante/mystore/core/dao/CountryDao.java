package net.andresbustamante.mystore.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.andresbustamante.mystore.core.entities.Country;

public interface CountryDao extends JpaRepository<Country, Integer> {
}
