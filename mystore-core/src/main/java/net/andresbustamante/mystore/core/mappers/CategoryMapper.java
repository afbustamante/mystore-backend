package net.andresbustamante.mystore.core.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import net.andresbustamante.mystore.api.model.CategoryDto;
import net.andresbustamante.mystore.core.config.MapstructEntityMapperConfig;
import net.andresbustamante.mystore.core.entities.Category;

@Mapper(config = MapstructEntityMapperConfig.class)
public interface CategoryMapper extends PageMapper<Category, CategoryDto> {

    CategoryDto map(Category category);

    List<CategoryDto> map(Collection<Category> categories);
}
