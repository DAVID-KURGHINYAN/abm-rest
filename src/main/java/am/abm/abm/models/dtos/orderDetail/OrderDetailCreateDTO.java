package am.abm.abm.models.dtos.orderDetail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailCreateDTO {
    private Long productId;
    private Long orderId;
    private int quantity;

}
