package ir.bourna.komeil.repositories;


import ir.bourna.komeil.models.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransportRepository extends JpaRepository<Transport, Long> {
    List<Transport> findAllByEnable(boolean enable);
}
