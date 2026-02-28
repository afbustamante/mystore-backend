package net.andresbustamante.mystore.core.services;

import java.util.Collection;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.andresbustamante.mystore.api.model.Category;
import net.andresbustamante.mystore.api.util.Page;
import net.andresbustamante.mystore.api.util.PagingRequest;
import net.andresbustamante.mystore.api.services.CategoriesSearchService;
import net.andresbustamante.mystore.jpa.mappers.CategoryEntityMapper;
import net.andresbustamante.mystore.jpa.dao.CategoryDao;

@Service
@Transactional(readOnly = true)
public class CategoriesSearchServiceImpl implements CategoriesSearchService {

    private final CategoryDao categoryDao;
    private final CategoryEntityMapper categoryEntityMapper;

    public CategoriesSearchServiceImpl(final CategoryDao categoryDao, final CategoryEntityMapper categoryEntityMapper) {
        this.categoryDao = categoryDao;
        this.categoryEntityMapper = categoryEntityMapper;
    }

    @Override
    public Collection<Category> findCategories() {
        var categories = categoryDao.findAll();
        return categoryEntityMapper.map(categories);
    }

    @Override
    public Page<Category> findCategories(final PagingRequest pagingRequest) {
        var categories = categoryDao.findAll(PageRequest.of(pagingRequest.pageNumber(), pagingRequest.pageSize()));
        return categoryEntityMapper.map(categories);
    }
}
