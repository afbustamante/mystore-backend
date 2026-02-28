package net.andresbustamante.mystore.api.services;

import java.util.Collection;

import net.andresbustamante.mystore.api.model.Order;
import net.andresbustamante.mystore.api.model.OrderSearchCriteria;
import net.andresbustamante.mystore.api.util.Page;
import net.andresbustamante.mystore.api.util.PagingRequest;

public interface OrdersSearchService {

    Collection<Order> findOrders(OrderSearchCriteria criteria);

    Page<Order> findOrders(OrderSearchCriteria criteria, PagingRequest pagingRequest);
}
