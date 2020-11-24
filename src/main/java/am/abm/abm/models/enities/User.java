package am.abm.abm.models.enities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class User extends Base {

    private String customerName;
    private String contactName;
    private String address;
    private String city;
    private String postalCode;
    private String country;
    private String avatar;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders;

}
