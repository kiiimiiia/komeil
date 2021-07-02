package ir.bourna.komeil.repositories;


import ir.bourna.komeil.models.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity,Long> {
}
