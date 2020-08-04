package am.abm.abm.enities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.util.Set;

@Entity
public class User extends Base {

    private String customerName;
    private String contactName;
    private String address;
    private String city;
    private String postalCode;
    private String country;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders;

}
