package soft_unibg.spring_advanced_query.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soft_unibg.spring_advanced_query.models.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}