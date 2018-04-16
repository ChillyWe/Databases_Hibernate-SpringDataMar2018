package soft_uni.product_shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import soft_uni.product_shop.models.dtos.views.ProductInRangeViewModel;
import soft_uni.product_shop.models.entity.Product;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT new soft_uni.product_shop.models.dtos.views.ProductInRangeViewModel(" +
            "p.name,p.price, TRIM(CONCAT(COALESCE(p.seller.firstName,'') ,' ',p.seller.lastName)) )" +
            " FROM Product AS p WHERE (p.price BETWEEN :from AND :to) AND " +
            "p.buyer IS NULL " +
            "ORDER BY p.price ASC")
    List<ProductInRangeViewModel> getAllByRangeWithoutBuyer(@Param("from") BigDecimal from, @Param("to") BigDecimal to);
}