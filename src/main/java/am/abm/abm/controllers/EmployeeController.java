package am.abm.abm.controllers;

import am.abm.abm.models.dtos.employee.EmployeeCreateDTO;
import am.abm.abm.models.dtos.employee.EmployeeDetailsDTO;
import am.abm.abm.models.dtos.employee.EmployeePreviewDTO;
import am.abm.abm.models.enities.Employee;
import am.abm.abm.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee/")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("list")
    public List<EmployeePreviewDTO> employeeList() {
        return employeeService.getAll();
    }

    @PostMapping("add")
    public EmployeePreviewDTO addEmployee(@RequestBody EmployeeCreateDTO employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("edit/{id}")
    public boolean editEmployee(@RequestBody EmployeeCreateDTO employee, @PathVariable Long id) {
        return employeeService.editEmployee(employee, id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("details/{id}")
    public EmployeePreviewDTO details(@PathVariable Long id) {
        return employeeService.getEmployeeDetails(id);
    }
}
