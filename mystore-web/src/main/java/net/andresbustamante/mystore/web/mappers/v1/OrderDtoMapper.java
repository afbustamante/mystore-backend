package net.andresbustamante.mystore.web.mappers.v1;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import net.andresbustamante.mystore.api.model.Order;
import net.andresbustamante.mystore.web.config.MapstructWebSpringConfig;
import net.andresbustamante.mystore.web.dto.v1.OrderDto;

@Mapper(config = MapstructWebSpringConfig.class)
public interface OrderDtoMapper {

    OrderDto map(Order order);

    List<OrderDto> map(Collection<Order> orders);
}
