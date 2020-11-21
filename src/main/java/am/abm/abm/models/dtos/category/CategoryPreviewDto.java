package am.abm.abm.models.dtos.category;

import am.abm.abm.models.enities.Category;
import am.abm.abm.models.enities.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryPreviewDto {
    private String categoryName;
    private String description;
    private Long categoryId;
    private int productsCount;
    private String categoryAvatar;

    public CategoryPreviewDto (Category category)
    {
        //this.setCategoryName(category.getCategoryName());
//        this.setProductsCount(category.getProducts().size());
//        this.setCategoryId(category.getId());
        //this.setDescription(category.getDescription());
//        this.setCategoryAvatar(category.getCategoryAvatar());
    }
}
