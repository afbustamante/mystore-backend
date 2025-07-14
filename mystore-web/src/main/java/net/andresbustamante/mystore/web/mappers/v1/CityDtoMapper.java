package net.andresbustamante.mystore.web.mappers.v1;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.andresbustamante.mystore.api.model.CityDto;
import net.andresbustamante.mystore.api.model.Page;
import net.andresbustamante.mystore.web.config.MapstructWebSpringConfig;
import net.andresbustamante.mystore.web.dto.v1.City;
import net.andresbustamante.mystore.web.dto.v1.CityPage;

@Mapper(config = MapstructWebSpringConfig.class)
public interface CityDtoMapper {

    City map(CityDto city);

    List<City> map(Collection<CityDto> cities);

    @Mapping(target = "cities", source = "elements")
    @Mapping(target = "numberOfElements", source = "pageSize")
    CityPage map(Page<CityDto> page);
}
