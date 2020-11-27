package am.abm.abm.models.dtos.order;

import am.abm.abm.models.enities.OrderDetail;
import am.abm.abm.models.enities.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDTO {
    private Long productId;
    private int quantity;

    public OrderDetail getOrderDetail(Product product) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProduct(product);
        orderDetail.setQuantity(this.quantity);
        return orderDetail;
    }
}
