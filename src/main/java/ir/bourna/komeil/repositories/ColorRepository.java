package ir.bourna.komeil.repositories;

import ir.bourna.komeil.models.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color ,Long> {
}
