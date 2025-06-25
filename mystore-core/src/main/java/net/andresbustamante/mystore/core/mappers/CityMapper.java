package net.andresbustamante.mystore.core.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import net.andresbustamante.mystore.api.model.CityDto;
import net.andresbustamante.mystore.core.config.MapstructEntityMapperConfig;
import net.andresbustamante.mystore.core.entities.City;

@Mapper(config = MapstructEntityMapperConfig.class, uses = CountryMapper.class)
public interface CityMapper {

    CityDto map(City city);

    List<CityDto> map(Collection<City> cities);
}
