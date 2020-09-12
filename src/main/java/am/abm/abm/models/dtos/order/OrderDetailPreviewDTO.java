package am.abm.abm.models.dtos.order;

import am.abm.abm.models.enities.OrderDetail;

public class OrderDetailPreviewDTO {
    private long orderId;
    private long orderDetailId;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public OrderDetailPreviewDTO(OrderDetail orderDetail){
        setOrderDetailId(orderDetail.getId());
        setOrderId(orderDetail.getOrder().getId());
    }
}
