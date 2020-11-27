package am.abm.abm.models.dtos.order;

import am.abm.abm.models.enities.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderPreviewDTO {
    private long orderId;

    public OrderPreviewDTO(Order order) {
        orderId = order.getId();
    }

}
