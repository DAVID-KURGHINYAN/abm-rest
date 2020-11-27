package am.abm.abm.models.dtos.order;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderCreateDTO {
    private Long customerId;
    List<OrderItemDTO> items;

}
