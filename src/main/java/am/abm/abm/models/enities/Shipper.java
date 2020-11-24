package am.abm.abm.models.enities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Shipper extends Base {
    private String shipperName;
    private Long phone;

    @OneToMany(mappedBy = "shipper")
    private Set<Order> orders;

}
