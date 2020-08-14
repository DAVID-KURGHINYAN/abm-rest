package am.abm.abm.services;

import am.abm.abm.models.dtos.employee.EmployeeCreateDTO;
import am.abm.abm.models.dtos.employee.EmployeeDetailsDTO;
import am.abm.abm.models.enities.Employee;
import am.abm.abm.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDetailsDTO getEmployeeDetails(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            return new EmployeeDetailsDTO(employee);
        }
        return null;
    }

    public List<Employee> getAll() {
        return null;
    }

    public Employee saveEmployee(EmployeeCreateDTO employeeCreateDTO) {
        Employee employee = new Employee();
        employee.setFirstName(employeeCreateDTO.getFirstName());
        employee.setLastName(employeeCreateDTO.getLastName());
        employee.setBirthDate(employeeCreateDTO.getBirthDate());
        employee.setPhoto(employeeCreateDTO.getPhoto());
        employee.setNotes(employeeCreateDTO.getNotes());
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public boolean editEmployee(EmployeeCreateDTO employee, Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee oldEmployee = optionalEmployee.get();
            oldEmployee.setFirstName(employee.getFirstName());
            oldEmployee.setLastName(employee.getLastName());
            oldEmployee.setBirthDate(employee.getBirthDate());
            oldEmployee.setPhoto(employee.getPhoto());
            oldEmployee.setNotes(employee.getNotes());
            employeeRepository.save(oldEmployee);
            return true;
        }
        return false;
    }
}
