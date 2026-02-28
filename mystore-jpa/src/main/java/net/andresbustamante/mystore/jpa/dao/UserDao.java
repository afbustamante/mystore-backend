package net.andresbustamante.mystore.jpa.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.andresbustamante.mystore.jpa.entities.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Integer> {

    boolean existsByUsername(String username);

    Optional<UserEntity> findByUsername(String username);
}
