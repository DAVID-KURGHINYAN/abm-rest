package am.abm.abm.models.dtos.category;

import am.abm.abm.models.dtos.product.ProductPreviewDTO;
import am.abm.abm.models.enities.Category;
import am.abm.abm.models.enities.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryDetailsDTO {
    private Long id;
    private String categoryName;

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

    public CategoryDetailsDTO(Category category) {
        id = category.getId();
        categoryName = category.getCategoryName();
        products = new ArrayList<>();
        category.getProducts().forEach(product -> {
            products.add(new ProductPreviewDTO(product));
        });
    }
}
