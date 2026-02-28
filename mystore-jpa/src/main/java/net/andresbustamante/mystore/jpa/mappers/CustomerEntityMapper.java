package net.andresbustamante.mystore.jpa.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.andresbustamante.mystore.api.model.Customer;
import net.andresbustamante.mystore.jpa.config.MapstructEntityMapperConfig;
import net.andresbustamante.mystore.jpa.entities.CustomerEntity;

@Mapper(config = MapstructEntityMapperConfig.class)
public interface CustomerEntityMapper extends PageMapper<CustomerEntity, Customer> {

    @Mapping(target = "username", source = "user.username")
    Customer map(CustomerEntity customer);

    List<Customer> map(Collection<CustomerEntity> customers);
}
