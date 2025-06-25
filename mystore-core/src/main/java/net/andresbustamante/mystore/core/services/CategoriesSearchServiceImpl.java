package net.andresbustamante.mystore.core.services;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.andresbustamante.mystore.api.model.CategoryDto;
import net.andresbustamante.mystore.api.services.CategoriesSearchService;
import net.andresbustamante.mystore.core.dao.CategoryDao;

@Service
@Transactional(readOnly = true)
public class CategoriesSearchServiceImpl implements CategoriesSearchService {

    private final CategoryDao categoryDao;

    public CategoriesSearchServiceImpl(final CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Collection<CategoryDto> findCategories() {
        return categoryDao.findAll().stream().map(category -> new CategoryDto(category.getId(), category.getName())).toList();
    }
}
