package ir.bourna.komeil.repositories;

import ir.bourna.komeil.models.intermediate.ProductitemColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductitemColorRepository extends JpaRepository<ProductitemColor,Long> {
}
