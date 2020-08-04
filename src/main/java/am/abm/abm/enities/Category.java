package am.abm.abm.enities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Category extends Base {

    private String categoryName;
    private String description;

    @OneToMany(mappedBy="category")
    private Set<Product> products;

    public Category(){}

}
