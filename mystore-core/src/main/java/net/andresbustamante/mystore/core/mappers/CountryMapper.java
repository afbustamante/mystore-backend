package net.andresbustamante.mystore.core.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.andresbustamante.mystore.core.config.MapstructEntityMapperConfig;
import net.andresbustamante.mystore.core.entities.Country;

@Mapper(config = MapstructEntityMapperConfig.class)
public interface CountryMapper {

    @Mapping(target = "cities", ignore = true)
    net.andresbustamante.mystore.api.model.Country map(Country country);

    List<net.andresbustamante.mystore.api.model.Country> map(Collection<Country> countries);
}
