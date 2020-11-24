package am.abm.abm.models.dtos.product;

import am.abm.abm.models.enities.Product;
import am.abm.abm.models.enities.ProductTranslation;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProductCreateDTO {
    private String unit;
    private int price;
    private long categoryId;
    private long supplierId;

    private List<ProductTranslationDTO> translationDTOS;

    public List<ProductTranslation> getProductTranslations(List<ProductTranslationDTO> productTranslationDTOS, Product product) {
        List<ProductTranslation> productTranslations = new ArrayList<>();
        productTranslationDTOS.forEach(productTranslationDTO -> {
            productTranslations.add(ProductTranslation.builder()
                    .product(product)
                    .description(productTranslationDTO.getDescription())
                    .language(productTranslationDTO.getLanguage())
                    .productName(productTranslationDTO.getProductName())
                    .build());
        });

        return productTranslations;
    }
}
