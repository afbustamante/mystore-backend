package net.andresbustamante.mystore.core.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.andresbustamante.mystore.core.entities.Order;

public interface OrderDao extends JpaRepository<Order, Integer> {

    List<Order> findAllByOrderDateBetween(LocalDate dateMin, LocalDate dateMax);
}
