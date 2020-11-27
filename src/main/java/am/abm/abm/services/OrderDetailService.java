package am.abm.abm.services;

import am.abm.abm.models.dtos.order.OrderDetailPreviewDTO;
import am.abm.abm.models.dtos.orderDetail.OrderDetailCreateDTO;
import am.abm.abm.models.dtos.orderDetail.OrderDetailDetailsDTO;
import am.abm.abm.models.enities.Order;
import am.abm.abm.models.enities.OrderDetail;
import am.abm.abm.models.enities.Product;
import am.abm.abm.repositories.OrderDetailRepository;
import am.abm.abm.repositories.OrderRepository;
import am.abm.abm.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderDetailService(OrderDetailRepository orderDetailRepository, ProductRepository productRepository, OrderRepository orderRepository) {
        this.orderDetailRepository = orderDetailRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public OrderDetailDetailsDTO getOrderDetailDetails(Long id) {
        Optional<OrderDetail> optionalOrderDetail = orderDetailRepository.findById(id);
        if (optionalOrderDetail.isPresent()) {
            OrderDetail orderDetail = optionalOrderDetail.get();
            return new OrderDetailDetailsDTO(orderDetail);
        }
        return null;
    }

    public List<OrderDetail> getAll() {
        return null;
    }

    public OrderDetailPreviewDTO saveOrderDetail(OrderDetailCreateDTO orderDetailCreateDTO) {

        Optional<Order> optionalOrder = orderRepository.findById(orderDetailCreateDTO.getOrderId());
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            Optional<Product> optionalProduct = productRepository.findById(orderDetailCreateDTO.getProductId());
            if (optionalProduct.isPresent()) {
                Product product = optionalProduct.get();
                Set<OrderDetail> details = order.getOrderDetails();
                boolean LAVA = false;
                for (OrderDetail orderDetail : details) {
                    if (orderDetail.getProduct().getId().equals(orderDetailCreateDTO.getProductId())) {
                        LAVA = true;
                        orderDetail.setQuantity(orderDetail.getQuantity() + orderDetailCreateDTO.getQuantity());
                    }
                }
                if (!LAVA) {
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setOrder(order);
                    orderDetail.setProduct(product);
                    orderDetail.setQuantity(orderDetailCreateDTO.getQuantity());
                   return new OrderDetailPreviewDTO(orderDetailRepository.save(orderDetail));
                }
            }
        }
        return null;
    }

    public void deleteOrderDetail(Long id) {
        orderDetailRepository.deleteById(id);
    }

    public boolean editOrderDetail(OrderDetailCreateDTO orderDetail, Long id) {
        Optional<OrderDetail> optionalOrderDetail = orderDetailRepository.findById(id);
        if (optionalOrderDetail.isPresent()) {
            OrderDetail oldOrderDetail1 = optionalOrderDetail.get();
            oldOrderDetail1.setQuantity(oldOrderDetail1.getQuantity());
            orderDetailRepository.save(oldOrderDetail1);
            return true;
        }
        return false;
    }
}
