package ir.bourna.komeil.repositories;

import ir.bourna.komeil.models.Admins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminsRepository extends JpaRepository<Admins, Long> {
    Admins findById(int id);
    Admins findByUsername(String username);
}
