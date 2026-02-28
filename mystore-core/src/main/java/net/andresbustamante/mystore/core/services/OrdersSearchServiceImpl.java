package net.andresbustamante.mystore.core.services;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.andresbustamante.mystore.api.model.Order;
import net.andresbustamante.mystore.api.model.OrderSearchCriteria;
import net.andresbustamante.mystore.api.util.Page;
import net.andresbustamante.mystore.api.util.PagingRequest;
import net.andresbustamante.mystore.api.services.OrdersSearchService;
import net.andresbustamante.mystore.jpa.dao.OrderDao;
import net.andresbustamante.mystore.jpa.entities.OrderEntity;
import net.andresbustamante.mystore.jpa.mappers.OrderEntityMapper;

@Service
@Transactional(readOnly = true)
public class OrdersSearchServiceImpl implements OrdersSearchService {

    private final OrderDao orderDao;
    private final OrderEntityMapper orderEntityMapper;

    public OrdersSearchServiceImpl(final OrderDao orderDao, final OrderEntityMapper orderEntityMapper) {
        this.orderDao = orderDao;
        this.orderEntityMapper = orderEntityMapper;
    }

    @Override
    public Collection<Order> findOrders(final OrderSearchCriteria criteria) {
        List<OrderEntity> orders = orderDao.findAllByDateBetween(criteria.getDateMin(), criteria.getDateMax());
        return orderEntityMapper.map(orders);
    }

    @Override
    public Page<Order> findOrders(final OrderSearchCriteria criteria, final PagingRequest pagingRequest) {
        return null;
    }
}
