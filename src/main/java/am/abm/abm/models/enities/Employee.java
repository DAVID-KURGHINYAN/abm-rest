package am.abm.abm.models.enities;

import javax.persistence.Entity;
import java.sql.Date;

@Entity
public class Employee extends Base {
    private String lastName;
    private String firstName;
    private Date birthDate;
    private String photo;
    private String notes;


    public Employee() {}
}
