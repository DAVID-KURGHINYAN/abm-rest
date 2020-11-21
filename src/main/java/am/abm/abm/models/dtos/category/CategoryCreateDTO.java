package am.abm.abm.models.dtos.category;

import am.abm.abm.models.enities.Category;
import am.abm.abm.models.enities.CategoryTranslation;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoryCreateDTO {
   private List<CategoryTranslationDTO> translations;

   public List<CategoryTranslation> getTranslations(List<CategoryTranslationDTO> categoryTranslationDTOS, Category category) {
      List<CategoryTranslation> translations = new ArrayList<>();
      categoryTranslationDTOS.forEach(categoryTranslationDTO -> {
         translations.add(CategoryTranslation.builder()
                 .category(category)
                 .categoryName(categoryTranslationDTO.getCategoryName())
                 .description(categoryTranslationDTO.getDescription())
                 .language(categoryTranslationDTO.getLanguage()).build());
      });

      return translations;
   }
}
