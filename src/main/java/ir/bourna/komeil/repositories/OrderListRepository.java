package ir.bourna.komeil.repositories;

import ir.bourna.komeil.models.Enums.OrderListStatus;
import ir.bourna.komeil.models.OrderList;
import ir.bourna.komeil.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderListRepository extends JpaRepository<OrderList, Long> {
    OrderList findAllByOrderListStatusAndUser(OrderListStatus orderListStatus , User user);
    List<OrderList> findAllByOrderListStatus(OrderListStatus orderListStatus );

}
