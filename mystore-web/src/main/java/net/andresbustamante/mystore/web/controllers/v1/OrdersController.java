package net.andresbustamante.mystore.web.controllers.v1;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.andresbustamante.mystore.api.model.Order;
import net.andresbustamante.mystore.api.model.OrderSearchCriteria;
import net.andresbustamante.mystore.api.services.OrdersSearchService;
import net.andresbustamante.mystore.web.dto.v1.OrderDto;
import net.andresbustamante.mystore.web.mappers.v1.OrderDtoMapper;

@RestController
@RequestMapping("/api/v1")
public class OrdersController {

    private final OrdersSearchService ordersSearchService;
    private final OrderDtoMapper orderDtoMapper;

    public OrdersController(final OrdersSearchService ordersSearchService, final OrderDtoMapper orderDtoMapper) {
        this.ordersSearchService = ordersSearchService;
        this.orderDtoMapper = orderDtoMapper;
    }

    @GetMapping("/orders")
    public ResponseEntity<Collection<OrderDto>> fetchOrders() {
        OrderSearchCriteria criteria = OrderSearchCriteria.builder()
                .dateMin(LocalDate.parse("2009-01-01"))
                .dateMax(LocalDate.parse("2009-01-31"))
                .build();
        Collection<Order> orders = ordersSearchService.findOrders(criteria);
        return ResponseEntity.ok(orderDtoMapper.map(orders));
    }
}
