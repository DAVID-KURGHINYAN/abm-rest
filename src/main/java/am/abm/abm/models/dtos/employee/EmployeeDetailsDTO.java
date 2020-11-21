package am.abm.abm.models.dtos.employee;

import am.abm.abm.models.enities.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDetailsDTO {
    private Long id;
    private String firstName;
    private String lastName;

    public EmployeeDetailsDTO(Employee employee) {
        id = employee.getId();
        firstName = employee.getFirstName();
        lastName = employee.getLastName();
    }
}
