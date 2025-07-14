package net.andresbustamante.mystore.core.services;

import java.util.Collection;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.andresbustamante.mystore.api.model.CategoryDto;
import net.andresbustamante.mystore.api.model.Page;
import net.andresbustamante.mystore.api.model.PagingRequest;
import net.andresbustamante.mystore.api.services.CategoriesSearchService;
import net.andresbustamante.mystore.core.dao.CategoryDao;
import net.andresbustamante.mystore.core.mappers.CategoryMapper;

@Service
@Transactional(readOnly = true)
public class CategoriesSearchServiceImpl implements CategoriesSearchService {

    private final CategoryDao categoryDao;
    private final CategoryMapper categoryMapper;

    public CategoriesSearchServiceImpl(final CategoryDao categoryDao, final CategoryMapper categoryMapper) {
        this.categoryDao = categoryDao;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Collection<CategoryDto> findCategories() {
        var categories = categoryDao.findAll();
        return categoryMapper.map(categories);
    }

    @Override
    public Page<CategoryDto> findCategories(final PagingRequest pagingRequest) {
        var categories = categoryDao.findAll(PageRequest.of(pagingRequest.pageNumber(), pagingRequest.pageSize()));
        return categoryMapper.map(categories);
    }
}
