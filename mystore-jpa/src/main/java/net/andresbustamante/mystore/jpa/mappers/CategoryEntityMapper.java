package net.andresbustamante.mystore.jpa.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import net.andresbustamante.mystore.api.model.Category;
import net.andresbustamante.mystore.jpa.config.MapstructEntityMapperConfig;
import net.andresbustamante.mystore.jpa.entities.CategoryEntity;

@Mapper(config = MapstructEntityMapperConfig.class)
public interface CategoryEntityMapper extends PageMapper<CategoryEntity, Category> {

    Category map(CategoryEntity category);

    List<Category> map(Collection<CategoryEntity> categories);
}
