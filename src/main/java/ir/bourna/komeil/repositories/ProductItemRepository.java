package ir.bourna.komeil.repositories;

import ir.bourna.komeil.models.ProductItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductItemRepository extends PagingAndSortingRepository<ProductItem , Long> {
    ProductItem findById(int id);
    ProductItem findByHashproduct(String hashproduct);
    List<ProductItem> findByProductCategory(Long id);
    List<ProductItem> findAllByBrandId(Long id);
    Page<ProductItem> findByNameContainsAndEnable( Pageable pageable , String name , Boolean enable);
    Page<ProductItem> findAllByEnable(Pageable pageRange , Boolean enable);

    @Query(value="SELECT * from product_item as p where (p.category_id=:categoryId AND p.enable=true AND p.hashproduct!=:hash) order by RAND() LIMIT 3", nativeQuery = true)
    List<ProductItem> relatedList(@Param("categoryId") Long id, @Param("hash") String hash);
}
