package am.abm.abm.models.dtos.product;

import am.abm.abm.models.enities.Product;
import am.abm.abm.models.enities.ProductTranslation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDetailsDTO {
    private Long id;
    private String productName;

    public ProductDetailsDTO(ProductTranslation translation) {
        id = translation.getProduct().getId();
        productName = translation.getProductName();
    }
}
