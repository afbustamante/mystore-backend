package net.andresbustamante.mystore.core.mappers;

import org.mapstruct.Mapping;

import net.andresbustamante.mystore.api.model.Page;

public interface PageMapper<T, D> {

    @Mapping(target = "pageNumber", source = "number")
    @Mapping(target = "pageSize", source = "numberOfElements")
    @Mapping(target = "elements", source = "content")
    Page<D> map(org.springframework.data.domain.Page<T> page);
}
