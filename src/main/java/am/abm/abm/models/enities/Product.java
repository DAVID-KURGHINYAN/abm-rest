package am.abm.abm.models.enities;

import javax.persistence.*;

@Entity
public class Product extends Base {
    private String productName;
    private String unit;
    private int price;

    @ManyToOne
    @JoinColumn(name="supplierId", nullable = false)
    Supplier supplier;

    @ManyToOne
    @JoinColumn(name="categoryId", nullable = false)
    Category category;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product(){}
}
