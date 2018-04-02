package soft_unibg.spring_advanced_query.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import soft_unibg.spring_advanced_query.models.entity.Book;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBooksByAgeRestriction(String restriction);

    List<Book> findBooksByCopiesBefore(Integer integer);

    @Query("select b from Book AS b where b.price not between :firstNum and :secondNum")
    List<Book> findBooksNotBetween(@Param("firstNum") BigDecimal firstNum,@Param("secondNum") BigDecimal secondNum);

    List<Book> findAllByReleaseDataIsNotLike(Date date);

    List<Book> findAllByReleaseDataBefore(Date date);

    List<Book> findAllByTitleContaining(String containThis);

    @Query("SELECT COUNT(b) FROM Book AS b WHERE LENGTH(b.title)> :count")
    Integer findAllByTitleLongerThan(@Param("count") Integer symbolCount);
}