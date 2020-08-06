package am.abm.abm.models.enities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Shipper extends Base {
    private String shipperName;
    private Long phone;

    @OneToMany(mappedBy="shipper")
    private Set<Order> orders;

    public Shipper(){}
}
