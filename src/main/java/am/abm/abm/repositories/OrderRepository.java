package am.abm.abm.repositories;

import am.abm.abm.models.enities.Order;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends BaseRepository<Order> {
    List<Order> findAllByEmployeeIsNotNull();
    List<Order> findAllByOrderDate(Date date);

}
