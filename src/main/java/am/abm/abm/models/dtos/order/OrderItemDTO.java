package am.abm.abm.models.dtos.order;

import am.abm.abm.models.enities.OrderDetail;
import am.abm.abm.models.enities.Product;

public class OrderItemDTO {
    private Long productId;
    private int quantity;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderDetail getOrderDetail(Product product) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProduct(product);
        orderDetail.setQuantity(this.quantity);
        return orderDetail;
    }
}
