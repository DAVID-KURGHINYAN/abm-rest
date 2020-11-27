package am.abm.abm.models.dtos.order;

import am.abm.abm.models.enities.OrderDetail;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailPreviewDTO {
    private long orderId;
    private long orderDetailId;

    public OrderDetailPreviewDTO(OrderDetail orderDetail){
        setOrderDetailId(orderDetail.getId());
        setOrderId(orderDetail.getOrder().getId());
    }
}
