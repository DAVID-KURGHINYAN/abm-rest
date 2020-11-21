package am.abm.abm.repositories;

import am.abm.abm.models.enities.Category;
import am.abm.abm.models.enities.CategoryTranslation;
import am.abm.abm.models.enums.Language;

import java.util.List;
import java.util.Optional;

public interface CategoryTranslateRepository extends BaseRepository<CategoryTranslation> {
    Optional<CategoryTranslation> findByCategoryAndLanguage(Category category, Language language);
}
