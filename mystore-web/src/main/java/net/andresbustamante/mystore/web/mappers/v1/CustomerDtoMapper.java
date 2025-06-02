package net.andresbustamante.mystore.web.mappers.v1;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import net.andresbustamante.mystore.api.model.Customer;
import net.andresbustamante.mystore.web.config.MapstructWebSpringConfig;
import net.andresbustamante.mystore.web.dto.v1.CustomerDto;

@Mapper(config = MapstructWebSpringConfig.class)
public interface CustomerDtoMapper {

    CustomerDto map(Customer customer);

    List<CustomerDto> map(Collection<Customer> customers);
}
