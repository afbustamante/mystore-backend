package net.andresbustamante.mystore.jpa.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.andresbustamante.mystore.jpa.entities.OrderEntity;

public interface OrderDao extends JpaRepository<OrderEntity, Integer> {

    List<OrderEntity> findAllByDateBetween(LocalDate dateMin, LocalDate dateMax);
}
