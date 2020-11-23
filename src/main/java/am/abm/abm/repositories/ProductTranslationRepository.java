package am.abm.abm.repositories;

import am.abm.abm.models.enities.Product;
import am.abm.abm.models.enities.ProductTranslation;
import am.abm.abm.models.enums.Language;

import java.util.Optional;

public interface ProductTranslationRepository extends BaseRepository<ProductTranslation>{
    Optional<ProductTranslation>findByProductAndLanguage(Product product, Language language);
}
