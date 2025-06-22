package net.andresbustamante.mystore.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.andresbustamante.mystore.core.entities.City;

public interface CityDao extends JpaRepository<City, Integer> {
}
