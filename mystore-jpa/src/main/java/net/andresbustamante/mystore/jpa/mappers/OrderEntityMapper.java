package net.andresbustamante.mystore.jpa.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.andresbustamante.mystore.api.model.Order;
import net.andresbustamante.mystore.jpa.config.MapstructEntityMapperConfig;
import net.andresbustamante.mystore.jpa.entities.OrderEntity;

@Mapper(config = MapstructEntityMapperConfig.class)
public interface OrderEntityMapper extends PageMapper<OrderEntity, Order> {

    @Mapping(target = "customerId", source = "customer.id")
    Order map(OrderEntity order);

    List<Order> map(Collection<OrderEntity> orders);
}
