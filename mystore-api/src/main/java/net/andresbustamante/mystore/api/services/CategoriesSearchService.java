package net.andresbustamante.mystore.api.services;

import java.util.Collection;

import net.andresbustamante.mystore.api.exceptions.ApplicationException;
import net.andresbustamante.mystore.api.model.Category;
import net.andresbustamante.mystore.api.util.Page;
import net.andresbustamante.mystore.api.util.PagingRequest;

public interface CategoriesSearchService {

    Collection<Category> findCategories() throws ApplicationException;

    Page<Category> findCategories(PagingRequest pagingRequest) throws ApplicationException;
}
