package am.abm.abm.models.dtos.category;

import am.abm.abm.models.dtos.product.ProductPreviewDTO;
import am.abm.abm.models.enities.CategoryTranslation;
import am.abm.abm.models.enities.ProductTranslation;
import am.abm.abm.models.enums.Language;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryDetailsDTO {
    private Long id;
    private String categoryName;
    private String avatar;

    List<ProductPreviewDTO> products;

    public List<ProductPreviewDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductPreviewDTO> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public CategoryDetailsDTO(CategoryTranslation translation, Language language) {
        id = translation.getCategory().getId();
        categoryName =  translation.getCategoryName();
        products = new ArrayList<>();
        avatar = "/media/image/" + translation.getCategory().getCategoryAvatar() + "/";
        translation.getCategory().getProducts().forEach(product -> {
            products.add(new ProductPreviewDTO(product, language, new ArrayList<>(product.getTranslations())));
        });
    }
}
