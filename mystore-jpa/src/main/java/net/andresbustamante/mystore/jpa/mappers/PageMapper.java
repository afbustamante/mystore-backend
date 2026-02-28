package net.andresbustamante.mystore.jpa.mappers;

import org.mapstruct.Mapping;

import net.andresbustamante.mystore.api.util.Page;

public interface PageMapper<T, D> {

    @Mapping(target = "pageNumber", source = "number")
    @Mapping(target = "pageSize", source = "numberOfElements")
    @Mapping(target = "elements", source = "content")
    Page<D> map(org.springframework.data.domain.Page<T> page);
}
