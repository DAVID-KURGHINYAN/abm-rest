package am.abm.abm.models.enities;

import javax.persistence.*;

@Entity
public class Product extends Base {
    private String productName;
    private String unit;
    private int price;

    @ManyToOne
    @JoinColumn(name="supplierID", nullable = false)
    Supplier supplier;

    @ManyToOne
    @JoinColumn(name="categoryId", nullable = false)
    Category category;

    public Product(){}
}
