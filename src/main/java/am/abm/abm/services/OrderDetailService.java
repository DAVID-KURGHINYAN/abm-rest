package am.abm.abm.services;

import am.abm.abm.models.dtos.orderDetail.OrderDetailCreateDTO;
import am.abm.abm.models.dtos.orderDetail.OrderDetailDetailsDTO;
import am.abm.abm.models.enities.OrderDetail;
import am.abm.abm.models.enities.User;
import am.abm.abm.repositories.OrderDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;

    public OrderDetailService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
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

    public OrderDetail saveOrderDetail(OrderDetailCreateDTO orderDetailCreateDTO) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setQuantity(orderDetailCreateDTO.getQuantity());
        return orderDetailRepository.save(orderDetail);
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
