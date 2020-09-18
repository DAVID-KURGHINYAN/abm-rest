package am.abm.abm.services;

import am.abm.abm.controllers.BaseController;
import am.abm.abm.models.dtos.order.OrderCreateDTO;
import am.abm.abm.models.dtos.order.OrderItemDTO;
import am.abm.abm.models.dtos.order.OrderPreviewDTO;
import am.abm.abm.models.enities.*;
import am.abm.abm.repositories.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;
    private final OrderDetailRepository orderDetailRepository;

    public OrderService(OrderRepository orderRepository,
                        ProductRepository productRepository,
                        UserRepository userRepository,
                        EmployeeRepository employeeRepository, OrderDetailRepository orderDetailRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.employeeRepository = employeeRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    public OrderPreviewDTO saveOrder(OrderCreateDTO orderCreateDTO) {
        List<OrderItemDTO> items = orderCreateDTO.getItems();

        if (items.size() > 0) {

            Set<OrderDetail> orderDetails = new HashSet<>();
            items.forEach(item -> {
                Optional<Product> product = productRepository.findById(item.getProductId());
                if (product.isPresent() && item.getQuantity() > 0) {
                    orderDetails.add(item.getOrderDetail(product.get()));
                }
            });

            Optional<User> optionalUser = userRepository.findById(orderCreateDTO.getCustomerId());
            if (optionalUser.isPresent() && orderDetails.size() > 0) {

                Order order = new Order();
                order.setUser(optionalUser.get());
                order.setOrderDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
                Order o = orderRepository.save(order);

                for (OrderDetail orderDetail : orderDetails) {
                    orderDetail.setOrder(o);
                    orderDetailRepository.save(orderDetail);
                }
                return new OrderPreviewDTO(o);
            }
        }
        return null;
    }

    public Order setEmployeeToOrder(Long orderId, Long employeeId) {

        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
            if (optionalEmployee.isPresent()) {
                Order order = optionalOrder.get();
                order.setEmployee(optionalEmployee.get());
                return orderRepository.save(order);
            }
        }
        return null;
    }

    public Order setShipperToOrder(Long orderId, Long shipperId) {
        return null;
    }

    public Order setOrderDateToOrder(Long orderId, Long orderDateId) {
        return null;
    }
}
