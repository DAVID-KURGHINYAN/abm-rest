package am.abm.abm.services;

import am.abm.abm.models.dtos.order.OrderCreateDTO;
import am.abm.abm.models.dtos.order.OrderItemDTO;
import am.abm.abm.models.enities.*;
import am.abm.abm.repositories.*;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;

    public OrderService(OrderRepository orderRepository,
                        ProductRepository productRepository,
                        UserRepository userRepository,
                        EmployeeRepository employeeRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.employeeRepository = employeeRepository;
    }

    public Order saveOrder(OrderCreateDTO orderCreateDTO) {
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
                order.setOrderDetails(orderDetails);
                order.setUser(optionalUser.get());
                return orderRepository.save(order);
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
