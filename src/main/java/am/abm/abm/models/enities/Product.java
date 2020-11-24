package am.abm.abm.models.enities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Product extends Base {
    private String productName;
    private String unit;
    private int price;

    @ManyToOne
    @JoinColumn(name = "supplierId", nullable = false)
    Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    Category category;

    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "product")
    private Set<ProductTranslation> translations;

    public Product() {
    }
}
