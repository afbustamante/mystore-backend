package net.andresbustamante.mystore.core.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.andresbustamante.mystore.api.model.CountryDto;
import net.andresbustamante.mystore.core.config.MapstructEntityMapperConfig;
import net.andresbustamante.mystore.core.entities.Country;

@Mapper(config = MapstructEntityMapperConfig.class)
public interface CountryMapper extends PageMapper<Country, CountryDto> {

    @Mapping(target = "cities", ignore = true)
    CountryDto map(Country country);

    List<CountryDto> map(Collection<Country> countries);
}
