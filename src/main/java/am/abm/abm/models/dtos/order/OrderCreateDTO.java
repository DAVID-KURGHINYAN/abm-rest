package am.abm.abm.models.dtos.order;

import java.util.List;

public class OrderCreateDTO {
    private Long customerId;
    List<OrderItemDTO> items;


    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }
}
