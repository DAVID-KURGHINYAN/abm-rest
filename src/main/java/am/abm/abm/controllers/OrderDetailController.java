package am.abm.abm.controllers;

import am.abm.abm.models.dtos.order.OrderDetailPreviewDTO;
import am.abm.abm.models.dtos.orderDetail.OrderDetailCreateDTO;
import am.abm.abm.models.dtos.orderDetail.OrderDetailDetailsDTO;
import am.abm.abm.models.dtos.user.UserCreateDTO;
import am.abm.abm.models.dtos.user.UserDetailsDTO;
import am.abm.abm.models.enities.OrderDetail;
import am.abm.abm.services.OrderDetailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orderDetail/")
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @GetMapping("list")
    public List<OrderDetail> orderDetailList() {
        return orderDetailService.getAll();
    }

    @PostMapping("add")
    public OrderDetailPreviewDTO addOrderDetail(@RequestBody OrderDetailCreateDTO orderDetail) {
        return orderDetailService.saveOrderDetail(orderDetail);
    }

    @PutMapping("edit/{id}")
    public boolean editOrderDetail(@RequestBody OrderDetailCreateDTO orderDetail, @PathVariable Long id) {
        return orderDetailService.editOrderDetail(orderDetail, id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteOrderDetail(@PathVariable Long id) {
        orderDetailService.deleteOrderDetail(id);
    }

    @GetMapping("details/{id}")
    public OrderDetailDetailsDTO details(@PathVariable Long id) {
        return orderDetailService.getOrderDetailDetails(id);
    }
}
