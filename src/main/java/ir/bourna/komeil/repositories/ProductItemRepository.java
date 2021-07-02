package ir.bourna.komeil.repositories;

import ir.bourna.komeil.models.ProductItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
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
}
