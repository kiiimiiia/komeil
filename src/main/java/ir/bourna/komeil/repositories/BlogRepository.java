package ir.bourna.komeil.repositories;


import ir.bourna.komeil.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findAllByEnable(Boolean enable);

}
