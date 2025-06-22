package net.andresbustamante.mystore.core.mappers;

import org.mapstruct.Mapper;

import net.andresbustamante.mystore.core.config.MapstructEntityMapperConfig;
import net.andresbustamante.mystore.core.entities.Address;

@Mapper(config = MapstructEntityMapperConfig.class, uses = CityMapper.class)
public interface AddressMapper {

    net.andresbustamante.mystore.api.model.Address map(Address address);
}
