package ir.bourna.komeil.repositories;

import ir.bourna.komeil.models.OrderList;
import ir.bourna.komeil.models.intermediate.OrderListProductItemNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderListProductItemNumberRepository extends JpaRepository<OrderListProductItemNumber, Long> {
}
