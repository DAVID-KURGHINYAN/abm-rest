package am.abm.abm.models.enities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "Orders")
public class Order extends Base {

    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "employee_Id", nullable = false)
    Employee employee;

    @ManyToOne
    @JoinColumn(name = "user_Id", nullable = false)
    User user;

    @ManyToOne
    @JoinColumn(name = "shipper_Id", nullable = false)
    Shipper shipper;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails;

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Order() {
    }
}
