package am.abm.abm.models.dtos.category;

import am.abm.abm.models.enities.Category;
import am.abm.abm.models.enities.Product;


public class CategoryPreviewDto {
    private String categoryName;
    private String description;
    private Long categoryId;
    private int productsCount;
    private String categoryAvatar;

    public String getCategoryAvatar() {
        return categoryAvatar;
    }

    public void setCategoryAvatar(String categoryAvatar) {
        this.categoryAvatar = categoryAvatar;
    }

    public int getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(int productsCount) {
        this.productsCount = productsCount;
    }

    public CategoryPreviewDto() {
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    public CategoryPreviewDto (Category category)
    {
        this.setCategoryName(category.getCategoryName());
        this.setProductsCount(category.getProducts().size());
        this.setCategoryId(category.getId());
        this.setDescription(category.getDescription());
        this.setCategoryAvatar(category.getCategoryAvatar());
    }
}
