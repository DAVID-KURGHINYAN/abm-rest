package am.abm.abm.models.dtos.employee;

import am.abm.abm.models.enities.Employee;

public class EmployeeDetailsDTO {
    private Long id;
    private String firstName;
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EmployeeDetailsDTO(Employee employee) {
        id = employee.getId();
        firstName = employee.getFirstName();
        lastName = employee.getLastName();
    }
}
