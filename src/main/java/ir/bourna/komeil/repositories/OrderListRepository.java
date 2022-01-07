package ir.bourna.komeil.repositories;

import ir.bourna.komeil.models.Enums.OrderStatus;
import ir.bourna.komeil.models.OrderList;
import ir.bourna.komeil.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderListRepository extends JpaRepository<OrderList, Long> {
    OrderList findAllByOrderStatusAndUser(OrderStatus orderStatus, User user);
    List<OrderList> findAllByOrderStatus(OrderStatus orderStatus);

}
