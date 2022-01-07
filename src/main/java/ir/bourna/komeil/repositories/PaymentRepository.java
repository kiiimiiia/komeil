package ir.bourna.komeil.repositories;

import ir.bourna.komeil.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
    Payment findByOrderListIdAndAmount(Long orderListId,int amount);
}
