package net.andresbustamante.mystore.web.mappers.v1;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.andresbustamante.mystore.api.model.Country;
import net.andresbustamante.mystore.api.util.Page;
import net.andresbustamante.mystore.web.config.MapstructWebSpringConfig;
import net.andresbustamante.mystore.web.dto.v1.CountryDto;
import net.andresbustamante.mystore.web.dto.v1.CountryPage;

@Mapper(config = MapstructWebSpringConfig.class)
public interface CountryDtoMapper {

    CountryDto map(Country country);

    List<CountryDto> map(Collection<Country> countries);

    @Mapping(target = "countries", source = "elements")
    @Mapping(target = "numberOfElements", source = "pageSize")
    CountryPage map(Page<Country> page);
}
