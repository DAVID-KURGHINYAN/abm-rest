package am.abm.abm.models.dtos.orderDetail;

import am.abm.abm.models.enities.OrderDetail;

public class OrderDetailPreviewDto {
    private String productName;
    private int quantity;
    private Long id;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderDetailPreviewDto(OrderDetail product)
    {
        this.setQuantity(product.getQuantity());
        this.setId(product.getId());
        this.setProductName(product.getProduct().getProductName());
    }

    public OrderDetailPreviewDto() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
