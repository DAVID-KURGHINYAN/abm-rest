package am.abm.abm.models.dtos.product;

import am.abm.abm.models.enities.Product;

public class ProductDetailsDTO {
    private Long id;
    private String productName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductDetailsDTO(Product product) {
        id = product.getId();
        productName = product.getProductName();
    }
}
