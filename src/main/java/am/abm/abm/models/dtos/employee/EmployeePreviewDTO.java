package am.abm.abm.models.dtos.employee;

import am.abm.abm.models.dtos.order.OrderPreviewDTO;
import am.abm.abm.models.enities.Employee;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeePreviewDTO {
    private long employeeId;
    private int ordersCount;
    private String fullName;
    private Set<OrderPreviewDTO> orderList;

    public Set<OrderPreviewDTO> getOrderList() {
        return orderList;
    }

    public void setOrderList(Set<OrderPreviewDTO> orderList) {
        this.orderList = orderList;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public int getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(int ordersCount) {
        this.ordersCount = ordersCount;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
