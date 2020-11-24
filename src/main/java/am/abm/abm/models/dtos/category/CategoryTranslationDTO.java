package am.abm.abm.models.dtos.category;

import am.abm.abm.models.enities.CategoryTranslation;
import am.abm.abm.models.enums.Language;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryTranslationDTO {
    private String categoryName;
    private String description;
    private Language language;

    public CategoryTranslationDTO(CategoryTranslation translation) {
        this.categoryName = translation.getCategoryName();
        this.description = translation.getDescription();
        this.language = translation.getLanguage();
    }
}
