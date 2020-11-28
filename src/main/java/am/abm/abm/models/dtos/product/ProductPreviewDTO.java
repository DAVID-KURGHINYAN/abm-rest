package am.abm.abm.models.dtos.product;

import am.abm.abm.models.enities.CategoryTranslation;
import am.abm.abm.models.enities.Product;
import am.abm.abm.models.enities.ProductTranslation;
import am.abm.abm.models.enums.Language;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
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

    public ProductPreviewDTO(Product product, Language language, List<ProductTranslation> translations) {

        Optional<ProductTranslation> productTranslation =
                translations.stream().filter(translation -> translation.getLanguage() == language).findFirst();
        this.setSupplierName(product.getSupplier().getSupplierName());

        Optional<CategoryTranslation> ctr = product.getCategory().getTranslations().stream().filter(tr -> tr.getLanguage() == language).findFirst();
        ctr.ifPresent(translation -> this.setCategoryName(translation.getCategoryName()));

        productTranslation.ifPresent(translation -> this.setProductName(translation.getProductName()));
        this.setPrice(product.getPrice());
        this.setUnit(product.getUnit());
        this.setId(product.getId());
    }
}
