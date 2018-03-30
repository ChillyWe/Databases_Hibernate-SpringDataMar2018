package soft_unibg.spring_advanced_query.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soft_unibg.spring_advanced_query.models.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBooksByAgeRestriction(String restriction);

    List<Book> findBooksByCopiesBefore(Integer integer);
}