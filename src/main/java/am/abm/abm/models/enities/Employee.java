package am.abm.abm.models.enities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends Base {
    private String lastName;
    private String firstName;
    private Date birthDate;
    private String photo;
    private String notes;

    @OneToMany(mappedBy = "employee")
    private Set<Order> orders;

}
