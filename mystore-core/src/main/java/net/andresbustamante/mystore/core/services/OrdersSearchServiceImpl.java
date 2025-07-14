package net.andresbustamante.mystore.core.services;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.andresbustamante.mystore.api.model.OrderDto;
import net.andresbustamante.mystore.api.model.OrderSearchCriteria;
import net.andresbustamante.mystore.api.model.Page;
import net.andresbustamante.mystore.api.model.PagingRequest;
import net.andresbustamante.mystore.api.services.OrdersSearchService;
import net.andresbustamante.mystore.core.dao.OrderDao;
import net.andresbustamante.mystore.core.entities.Order;
import net.andresbustamante.mystore.core.mappers.OrderMapper;

@Service
@Transactional(readOnly = true)
public class OrdersSearchServiceImpl implements OrdersSearchService {

    private final OrderDao orderDao;
    private final OrderMapper orderMapper;

    public OrdersSearchServiceImpl(final OrderDao orderDao, final OrderMapper orderMapper) {
        this.orderDao = orderDao;
        this.orderMapper = orderMapper;
    }

    @Override
    public Collection<OrderDto> findOrders(final OrderSearchCriteria criteria) {
        List<Order> orders = orderDao.findAllByDateBetween(criteria.getDateMin(), criteria.getDateMax());
        return orderMapper.map(orders);
    }

    @Override
    public Page<OrderDto> findOrders(final OrderSearchCriteria criteria, final PagingRequest pagingRequest) {
        return null;
    }
}
