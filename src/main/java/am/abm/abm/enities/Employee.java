package am.abm.abm.enities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.Set;

@Entity
public class Employee extends Base {
    private String lastName;
    private String firstName;
    private Date birthDate;
    private String photo;
    private String notes;


    public Employee() {}
}
