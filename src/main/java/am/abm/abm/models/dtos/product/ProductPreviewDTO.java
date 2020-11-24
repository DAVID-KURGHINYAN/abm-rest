package am.abm.abm.models.dtos.product;

import am.abm.abm.models.enities.Product;
import am.abm.abm.models.enities.ProductTranslation;
import am.abm.abm.models.enums.Language;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class ProductPreviewDTO {
    private String productName;
    private String unit;
    private int price;
    private String categoryName;
    private String supplierName;
    private long id;

    public ProductPreviewDTO(Product product, Language language) {

        Optional<ProductTranslation> productTranslation =
                product.getTranslations().stream().filter(translation -> translation.getLanguage() == language).findFirst();
        //this.setCategoryName(product.getCategory().getCategoryName());
        this.setSupplierName(product.getSupplier().getSupplierName());
        productTranslation.ifPresent(translation -> this.setProductName(translation.getProductName()));
        this.setPrice(product.getPrice());
        this.setUnit(product.getUnit());
        this.setId(product.getId());
    }
}
