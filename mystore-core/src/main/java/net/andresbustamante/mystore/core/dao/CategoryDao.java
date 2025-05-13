package net.andresbustamante.mystore.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.andresbustamante.mystore.core.entities.Category;

public interface CategoryDao extends JpaRepository<Category, Short> {
}
