package am.abm.abm.models.dtos.product;

import am.abm.abm.models.enities.Product;

public class ProductPreviewDTO {
    private String productName;
    private String unit;
    private int price;
    private String categoryName;
    private String supplierName;

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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public ProductPreviewDTO(Product product)
    {
        this.setCategoryName(product.getCategory().getCategoryName());
        this.setSupplierName(product.getSupplier().getSupplierName());
        this.setProductName(product.getProductName());
        this.setPrice(product.getPrice());
        this.setUnit(product.getUnit());
    }
}
