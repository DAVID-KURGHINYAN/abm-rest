package am.abm.abm.models.dtos.order;

import am.abm.abm.models.enities.Order;

public class OrderPreviewDTO {
    private long orderId;

    public OrderPreviewDTO(Order order) {
        orderId = order.getId();
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
}
