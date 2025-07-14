package net.andresbustamante.mystore.api.services;

import java.util.Collection;

import net.andresbustamante.mystore.api.model.OrderDto;
import net.andresbustamante.mystore.api.model.OrderSearchCriteria;
import net.andresbustamante.mystore.api.model.Page;
import net.andresbustamante.mystore.api.model.PagingRequest;

public interface OrdersSearchService {

    Collection<OrderDto> findOrders(OrderSearchCriteria criteria);

    Page<OrderDto> findOrders(OrderSearchCriteria criteria, PagingRequest pagingRequest);
}
