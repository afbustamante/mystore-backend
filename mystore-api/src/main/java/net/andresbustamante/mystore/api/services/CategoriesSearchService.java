package net.andresbustamante.mystore.api.services;

import java.util.Collection;

import net.andresbustamante.mystore.api.model.CategoryDto;

public interface CategoriesSearchService {

    Collection<CategoryDto> findCategories();
}
