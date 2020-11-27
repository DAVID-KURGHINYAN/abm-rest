package am.abm.abm.models.dtos.product;

import am.abm.abm.models.enities.ProductTranslation;
import am.abm.abm.models.enums.Language;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductTranslationDTO {
    private String productName;
    private String description;
    private Language language;

    public ProductTranslationDTO(ProductTranslation productTranslation) {
        this.productName = productTranslation.getProductName();
        this.description = productTranslation.getDescription();
        this.language = productTranslation.getLanguage();
    }
}
