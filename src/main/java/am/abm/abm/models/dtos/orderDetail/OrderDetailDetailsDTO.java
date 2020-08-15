package am.abm.abm.models.dtos.orderDetail;

import am.abm.abm.models.enities.OrderDetail;

public class OrderDetailDetailsDTO {
    private Long id;
    private int quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderDetailDetailsDTO(OrderDetail orderDetail) {
        id = orderDetail.getId();
        quantity = orderDetail.getQuantity();
    }
}
