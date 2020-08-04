package am.abm.abm.enities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Supplier extends Base {
    private String supplierName;
    private String contactName;
    private String address;
    private String city;
    private String postalCode;
    private String country;
    private Long phone;

    @OneToMany(mappedBy="supplier")
    private Set<Product> products;

    public Supplier(){}
}
