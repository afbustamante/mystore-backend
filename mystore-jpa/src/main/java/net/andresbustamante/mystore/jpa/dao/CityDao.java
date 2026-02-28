package net.andresbustamante.mystore.jpa.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.andresbustamante.mystore.jpa.entities.CityEntity;

public interface CityDao extends JpaRepository<CityEntity, Integer> {

    List<CityEntity> findByCountryId(Integer id);

    Page<CityEntity> findByCountryId(Integer id, Pageable pageRequest);
}
