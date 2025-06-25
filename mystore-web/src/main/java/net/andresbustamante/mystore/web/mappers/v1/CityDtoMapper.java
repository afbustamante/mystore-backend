package net.andresbustamante.mystore.web.mappers.v1;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import net.andresbustamante.mystore.web.config.MapstructWebSpringConfig;
import net.andresbustamante.mystore.web.dto.v1.City;

@Mapper(config = MapstructWebSpringConfig.class)
public interface CityDtoMapper {

    City map(net.andresbustamante.mystore.api.model.City city);

    List<City> map(Collection<net.andresbustamante.mystore.api.model.City> cities);
}
