package net.andresbustamante.mystore.jpa.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import net.andresbustamante.mystore.api.model.City;
import net.andresbustamante.mystore.jpa.config.MapstructEntityMapperConfig;
import net.andresbustamante.mystore.jpa.entities.CityEntity;

@Mapper(config = MapstructEntityMapperConfig.class, uses = CountryEntityMapper.class)
public interface CityEntityMapper extends PageMapper<CityEntity, City> {

    City map(CityEntity city);

    List<City> map(Collection<CityEntity> cities);
}
