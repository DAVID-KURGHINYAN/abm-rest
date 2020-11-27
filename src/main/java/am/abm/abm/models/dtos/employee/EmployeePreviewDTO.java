package am.abm.abm.models.dtos.employee;

import am.abm.abm.models.dtos.order.OrderPreviewDTO;
import am.abm.abm.models.enities.Employee;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class EmployeePreviewDTO {
    private long employeeId;
    private int ordersCount;
    private String fullName;
    private Set<OrderPreviewDTO> orderList;

    public Set<OrderPreviewDTO> getOrderList() {
        return orderList;
    }

    public EmployeePreviewDTO(Employee employee) {
        setEmployeeId(employee.getId());
        setFullName(employee.getFirstName().concat(" ").concat(employee.getLastName()));
        setOrdersCount(employee.getOrders().size());
        orderList = new HashSet<>();
        employee.getOrders().forEach(item->{
            orderList.add(new OrderPreviewDTO(item));
        });
    }

    public static List<EmployeePreviewDTO> getEmployees(List<Employee> employees) {
        return employees.stream().map(EmployeePreviewDTO::new).collect(Collectors.toList());
    }
}
