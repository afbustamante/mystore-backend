package net.andresbustamante.mystore.web.mappers.v1;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import net.andresbustamante.mystore.api.model.OrderDto;
import net.andresbustamante.mystore.web.config.MapstructWebSpringConfig;
import net.andresbustamante.mystore.web.dto.v1.OrderItem;

@Mapper(config = MapstructWebSpringConfig.class)
public interface OrderDtoMapper {

    OrderItem map(OrderDto order);

    List<OrderItem> map(Collection<OrderDto> orders);
}
