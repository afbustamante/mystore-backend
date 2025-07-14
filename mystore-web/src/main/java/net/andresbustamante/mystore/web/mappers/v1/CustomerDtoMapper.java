package net.andresbustamante.mystore.web.mappers.v1;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.andresbustamante.mystore.api.model.CustomerDto;
import net.andresbustamante.mystore.api.model.Page;
import net.andresbustamante.mystore.web.config.MapstructWebSpringConfig;
import net.andresbustamante.mystore.web.dto.v1.CustomerItem;
import net.andresbustamante.mystore.web.dto.v1.CustomerPage;

@Mapper(config = MapstructWebSpringConfig.class)
public interface CustomerDtoMapper {

    CustomerItem map(CustomerDto customer);

    List<CustomerItem> map(Collection<CustomerDto> customers);

    @Mapping(target = "customers", source = "elements")
    @Mapping(target = "numberOfElements", source = "pageSize")
    CustomerPage map(Page<CustomerDto> page);
}
