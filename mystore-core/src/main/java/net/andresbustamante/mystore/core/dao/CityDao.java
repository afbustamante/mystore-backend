package net.andresbustamante.mystore.core.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.andresbustamante.mystore.core.entities.City;

public interface CityDao extends JpaRepository<City, Integer> {

    List<City> findByCountryId(Integer id);

    Page<City> findByCountryId(Integer id, Pageable pageRequest);
}
