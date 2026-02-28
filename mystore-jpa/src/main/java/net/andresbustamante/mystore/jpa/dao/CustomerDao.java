package net.andresbustamante.mystore.jpa.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.andresbustamante.mystore.jpa.entities.CustomerEntity;

public interface CustomerDao extends JpaRepository<CustomerEntity, Integer> {

    boolean existsByEmail(String email);

    @Query("""
            from CustomerEntity c
            inner join c.address a
            inner join a.city ci
            inner join ci.country co
            where co.name = :country
        """)
    List<CustomerEntity> findAllByCountry(@Param("country") String country);

    @Query("""
            from CustomerEntity c
            inner join c.address a
            inner join a.city ci
            inner join ci.country co
            where co.name = :country
        """)
    Page<CustomerEntity> findAllByCountry(@Param("country") String country, Pageable pageRequest);
}
