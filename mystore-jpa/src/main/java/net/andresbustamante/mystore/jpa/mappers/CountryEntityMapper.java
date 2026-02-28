package net.andresbustamante.mystore.jpa.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.andresbustamante.mystore.api.model.Country;
import net.andresbustamante.mystore.jpa.config.MapstructEntityMapperConfig;
import net.andresbustamante.mystore.jpa.entities.CountryEntity;

@Mapper(config = MapstructEntityMapperConfig.class)
public interface CountryEntityMapper extends PageMapper<CountryEntity, Country> {

    @Mapping(target = "cities", ignore = true)
    Country map(CountryEntity country);

    List<Country> map(Collection<CountryEntity> countries);
}
