package soft_unibg.spring_advanced_query.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soft_unibg.spring_advanced_query.models.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {


}