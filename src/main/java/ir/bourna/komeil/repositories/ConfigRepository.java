package ir.bourna.komeil.repositories;

import ir.bourna.komeil.models.Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigRepository extends JpaRepository<Config , Long> {
}
