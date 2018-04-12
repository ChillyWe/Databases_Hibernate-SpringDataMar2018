package soft_uni.product_shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soft_uni.product_shop.models.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}