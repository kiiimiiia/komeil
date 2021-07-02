package ir.bourna.komeil.repositories;

import ir.bourna.komeil.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends  JpaRepository<Roles, Long>  {
}
