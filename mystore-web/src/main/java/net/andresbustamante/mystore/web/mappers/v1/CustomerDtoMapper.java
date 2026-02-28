package net.andresbustamante.mystore.web.mappers.v1;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.andresbustamante.mystore.api.model.Customer;
import net.andresbustamante.mystore.api.util.Page;
import net.andresbustamante.mystore.web.config.MapstructWebSpringConfig;
import net.andresbustamante.mystore.web.dto.v1.CustomerItem;
import net.andresbustamante.mystore.web.dto.v1.CustomerPage;

@Mapper(config = MapstructWebSpringConfig.class)
public interface CustomerDtoMapper {

    CustomerItem map(Customer customer);

    List<CustomerItem> map(Collection<Customer> customers);

    @Mapping(target = "customers", source = "elements")
    @Mapping(target = "numberOfElements", source = "pageSize")
    CustomerPage map(Page<Customer> page);
}
