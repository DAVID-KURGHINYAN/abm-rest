package am.abm.abm.models.enities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Orders")
public class Order extends Base {

    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "employee_Id")
    Employee employee;

    @ManyToOne
    @JoinColumn(name = "user_Id", nullable = false)
    User user;

    @ManyToOne
    @JoinColumn(name = "shipper_Id")
    Shipper shipper;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails;
}
