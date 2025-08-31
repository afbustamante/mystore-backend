package net.andresbustamante.mystore.core.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.andresbustamante.mystore.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {

    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);
}
