package am.abm.abm.models.dtos.orderDetail;

import am.abm.abm.models.enities.OrderDetail;
import am.abm.abm.models.enities.ProductTranslation;
import am.abm.abm.models.enums.Language;

import java.util.Optional;

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

    public OrderDetailPreviewDto(OrderDetail orderDetail) {
        Optional<ProductTranslation> productTranslation =
                orderDetail.getProduct().getTranslations().stream().filter(translation -> translation.getLanguage() == Language.EN).findFirst();
        this.setQuantity(orderDetail.getQuantity());
        this.setId(orderDetail.getId());
        productTranslation.ifPresent(translation -> this.setProductName(translation.getProductName()));
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
