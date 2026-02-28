package net.andresbustamante.mystore.web.mappers.v1;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.andresbustamante.mystore.api.model.Order;
import net.andresbustamante.mystore.api.util.Page;
import net.andresbustamante.mystore.web.config.MapstructWebSpringConfig;
import net.andresbustamante.mystore.web.dto.v1.OrderItem;
import net.andresbustamante.mystore.web.dto.v1.OrderPage;

@Mapper(config = MapstructWebSpringConfig.class)
public interface OrderDtoMapper {

    OrderItem map(Order order);

    List<OrderItem> map(Collection<Order> orders);

    @Mapping(target = "orders", source = "elements")
    @Mapping(target = "numberOfElements", source = "pageSize")
    OrderPage map(Page<Order> page);
}
