package net.andresbustamante.mystore.core.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.andresbustamante.mystore.api.model.OrderDto;
import net.andresbustamante.mystore.core.config.MapstructEntityMapperConfig;
import net.andresbustamante.mystore.core.entities.Order;

@Mapper(config = MapstructEntityMapperConfig.class)
public interface OrderMapper {

    @Mapping(target = "customerId", source = "customer.id")
    OrderDto map(Order order);

    List<OrderDto> map(Collection<Order> orders);
}
