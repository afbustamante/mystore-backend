package net.andresbustamante.mystore.core.services;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.andresbustamante.mystore.api.model.Order;
import net.andresbustamante.mystore.api.model.OrderSearchCriteria;
import net.andresbustamante.mystore.api.services.OrdersSearchService;
import net.andresbustamante.mystore.core.dao.OrderDao;

@Service
@Transactional(readOnly = true)
public class OrdersSearchServiceImpl implements OrdersSearchService {

    private final OrderDao orderDao;

    public OrdersSearchServiceImpl(final OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Collection<Order> findOrders(final OrderSearchCriteria criteria) {
        return orderDao.findAllByOrderDateBetween(criteria.getDateMin(), criteria.getDateMax()).stream().map(order -> {
            Order o = new Order();
            o.setId(order.getId());
            o.setDate(order.getOrderDate());
            o.setNetAmount(order.getNetAmount());
            o.setTotalAmount(order.getTotalAmount());
            o.setTax(order.getTax());
            o.setCustomerId(order.getCustomer().getId());
            return o;
        }).toList();
    }
}
