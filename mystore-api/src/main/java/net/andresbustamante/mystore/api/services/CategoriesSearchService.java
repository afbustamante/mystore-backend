package net.andresbustamante.mystore.api.services;

import java.util.Collection;

import net.andresbustamante.mystore.api.model.Category;
import net.andresbustamante.mystore.api.util.Page;
import net.andresbustamante.mystore.api.util.PagingRequest;

public interface CategoriesSearchService {

    Collection<Category> findCategories();

    Page<Category> findCategories(PagingRequest pagingRequest);
}
