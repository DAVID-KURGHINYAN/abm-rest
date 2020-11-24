package am.abm.abm.models.dtos.product;

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
}
