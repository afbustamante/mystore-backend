package net.andresbustamante.mystore.core.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.andresbustamante.mystore.api.model.CustomerDto;
import net.andresbustamante.mystore.core.config.MapstructEntityMapperConfig;
import net.andresbustamante.mystore.core.entities.Customer;

@Mapper(config = MapstructEntityMapperConfig.class)
public interface CustomerMapper {

    @Mapping(target = "username", source = "user.username")
    CustomerDto map(Customer customer);

    List<CustomerDto> map(Collection<Customer> customers);
}
