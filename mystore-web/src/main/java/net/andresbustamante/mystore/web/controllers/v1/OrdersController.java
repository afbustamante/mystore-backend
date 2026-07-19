package net.andresbustamante.mystore.web.controllers.v1;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.time.LocalDate;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.andresbustamante.mystore.api.exceptions.ApplicationException;
import net.andresbustamante.mystore.api.model.Order;
import net.andresbustamante.mystore.api.model.OrderSearchCriteria;
import net.andresbustamante.mystore.api.util.Page;
import net.andresbustamante.mystore.api.util.PagingRequest;
import net.andresbustamante.mystore.api.services.OrdersSearchService;
import net.andresbustamante.mystore.web.dto.v1.OrderPage;
import net.andresbustamante.mystore.web.mappers.v1.OrderDtoMapper;

@RestController
@RequestMapping("/api/v1")
public class OrdersController extends AbstractController implements OrdersApi {

    private final OrdersSearchService ordersSearchService;
    private final OrderDtoMapper orderDtoMapper;

    public OrdersController(
            final ObjectMapper objectMapper, final HttpServletRequest request,
            final OrdersSearchService ordersSearchService, final OrderDtoMapper orderDtoMapper) {
        super(objectMapper, request);

        this.ordersSearchService = ordersSearchService;
        this.orderDtoMapper = orderDtoMapper;
    }

    @Override
    public ResponseEntity<OrderPage> findOrders(final Integer pageNumber, final Integer pageSize) {
        OrderSearchCriteria criteria = OrderSearchCriteria.builder()
                .dateMin(LocalDate.parse("2009-01-01"))
                .dateMax(LocalDate.parse("2009-01-31"))
                .build();

        try {
            Page<Order> orders = ordersSearchService.findOrders(criteria, PagingRequest.of(pageNumber, pageSize));
            return ResponseEntity.ok(orderDtoMapper.map(orders));
        } catch (ApplicationException e) {
            throw new ResponseStatusException(INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
}
