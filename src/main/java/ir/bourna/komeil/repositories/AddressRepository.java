package ir.bourna.komeil.repositories;

import ir.bourna.komeil.models.Address;
import ir.bourna.komeil.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address , Long> {
    List<Address>findAllByUser(User user);
}
