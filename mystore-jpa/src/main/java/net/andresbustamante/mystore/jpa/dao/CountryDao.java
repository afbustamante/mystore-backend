package net.andresbustamante.mystore.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.andresbustamante.mystore.jpa.entities.CountryEntity;

public interface CountryDao extends JpaRepository<CountryEntity, Integer> {
}
