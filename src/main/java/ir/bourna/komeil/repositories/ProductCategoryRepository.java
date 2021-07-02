package ir.bourna.komeil.repositories;

import ir.bourna.komeil.models.ProductCategory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends PagingAndSortingRepository<ProductCategory, Long> {
    ProductCategory findByName(String name);
    List<ProductCategory> findAllByEnable(boolean enable);
}
