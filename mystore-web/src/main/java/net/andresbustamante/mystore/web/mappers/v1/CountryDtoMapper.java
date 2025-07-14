package net.andresbustamante.mystore.web.mappers.v1;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.andresbustamante.mystore.api.model.CountryDto;
import net.andresbustamante.mystore.api.model.Page;
import net.andresbustamante.mystore.web.config.MapstructWebSpringConfig;
import net.andresbustamante.mystore.web.dto.v1.Country;
import net.andresbustamante.mystore.web.dto.v1.CountryPage;

@Mapper(config = MapstructWebSpringConfig.class)
public interface CountryDtoMapper {

    Country map(CountryDto country);

    List<Country> map(Collection<CountryDto> countries);

    @Mapping(target = "countries", source = "elements")
    @Mapping(target = "numberOfElements", source = "pageSize")
    CountryPage map(Page<CountryDto> page);
}
