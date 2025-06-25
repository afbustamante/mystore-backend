package net.andresbustamante.mystore.api.services;

import java.util.Collection;

import net.andresbustamante.mystore.api.model.OrderDto;
import net.andresbustamante.mystore.api.model.OrderSearchCriteria;

public interface OrdersSearchService {

    Collection<OrderDto> findOrders(OrderSearchCriteria criteria);
}
