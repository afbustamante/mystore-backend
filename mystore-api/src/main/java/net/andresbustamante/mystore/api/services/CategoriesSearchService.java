package net.andresbustamante.mystore.api.services;

import java.util.Collection;

import net.andresbustamante.mystore.api.model.Category;

public interface CategoriesSearchService {

    Collection<Category> findCategories();
}
