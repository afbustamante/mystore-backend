package net.andresbustamante.mystore.api.services;

import java.util.Collection;

import net.andresbustamante.mystore.api.model.Order;
import net.andresbustamante.mystore.api.model.OrderSearchCriteria;

public interface OrdersSearchService {

    Collection<Order> findOrders(OrderSearchCriteria criteria);
}
