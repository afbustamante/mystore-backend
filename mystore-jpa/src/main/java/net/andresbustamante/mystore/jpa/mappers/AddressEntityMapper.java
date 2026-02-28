package net.andresbustamante.mystore.jpa.mappers;

import org.mapstruct.Mapper;

import net.andresbustamante.mystore.api.model.Address;
import net.andresbustamante.mystore.jpa.config.MapstructEntityMapperConfig;
import net.andresbustamante.mystore.jpa.entities.AddressEntity;

@Mapper(config = MapstructEntityMapperConfig.class, uses = CityEntityMapper.class)
public interface AddressEntityMapper {

    Address map(AddressEntity address);
}
