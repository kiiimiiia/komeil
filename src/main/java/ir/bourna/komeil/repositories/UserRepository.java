package ir.bourna.komeil.repositories;

import ir.bourna.komeil.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {
    User findByMobile(String mobile);
}
