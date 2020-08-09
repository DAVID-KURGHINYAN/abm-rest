package am.abm.abm.models.enities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Orderses")
public class Orders extends Base {


    private Date orderDate;

    @ManyToOne
    @JoinColumn(name="employee_Id", nullable = false)
    Employee employee;

    @ManyToOne
    @JoinColumn(name="user_Id", nullable = false)
    User user;

    @ManyToOne
    @JoinColumn(name="shipper_Id", nullable = false)
    Shipper shipper;

    public Orders() {}
}
