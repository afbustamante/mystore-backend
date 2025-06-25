package net.andresbustamante.mystore.web.mappers.v1;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import net.andresbustamante.mystore.api.model.CustomerDto;
import net.andresbustamante.mystore.web.config.MapstructWebSpringConfig;
import net.andresbustamante.mystore.web.dto.v1.CustomerItem;

@Mapper(config = MapstructWebSpringConfig.class)
public interface CustomerDtoMapper {

    CustomerItem map(CustomerDto customer);

    List<CustomerItem> map(Collection<CustomerDto> customers);
}
