package ir.bourna.komeil.repositories;

import ir.bourna.komeil.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository  extends JpaRepository<Brand , Long> {
}
