package ir.bourna.komeil.repositories;

import ir.bourna.komeil.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address , Long> {
}
