package net.andresbustamante.mystore.api.services;

import java.util.Collection;

import net.andresbustamante.mystore.api.model.CategoryDto;
import net.andresbustamante.mystore.api.model.Page;
import net.andresbustamante.mystore.api.model.PagingRequest;

public interface CategoriesSearchService {

    Collection<CategoryDto> findCategories();

    Page<CategoryDto> findCategories(PagingRequest pagingRequest);
}
