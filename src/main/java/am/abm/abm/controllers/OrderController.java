package am.abm.abm.controllers;

import am.abm.abm.models.dtos.order.OrderCreateDTO;
import am.abm.abm.models.dtos.order.OrderPreviewDTO;
import am.abm.abm.models.enities.Order;
import am.abm.abm.services.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order/")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("add")
    public OrderPreviewDTO addOrder(@RequestBody OrderCreateDTO orderCreateDTO) {
        return orderService.saveOrder(orderCreateDTO);
    }

    @PutMapping("addEmployee/{orderId}/{employeeId}")
    public Order setEmployeeToOrder(@PathVariable Long orderId, @PathVariable Long employeeId) {
        return orderService.setEmployeeToOrder(orderId, employeeId);
    }

    @PutMapping("addShipper/{orderId}/{shipperId}")
    public Order setShipperToOrder(@PathVariable Long orderId, @PathVariable Long shipperId) {
        return orderService.setShipperToOrder(orderId, shipperId);

    }

    @PutMapping("addOrderDate/{orderId}/{orderDateId}")
    public Order setOrderDateToOrder(@PathVariable Long orderId, @PathVariable Long orderDateId) {
        return orderService.setOrderDateToOrder(orderId, orderDateId);
    }
}
