package am.abm.abm.models.dtos.employee;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class EmployeeCreateDTO {
    private String lastName;
    private String firstName;
    private Date birthDate;
    private String photo;
    private String notes;

}
