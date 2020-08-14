package am.abm.abm.models.dtos.category;

import am.abm.abm.models.enities.Category;

public class CategoryDetailsDTO {
    private Long id;
    private String categoryName;

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

    public CategoryDetailsDTO(Category category) {
        id = category.getId();
        categoryName = category.getCategoryName();
    }
}
