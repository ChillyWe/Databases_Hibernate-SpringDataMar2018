package org.bookshop.repositories;

import org.bookshop.models.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT DISTINCT a FROM Book AS b INNER JOIN b.author AS a WHERE YEAR(b.releaseData) < :year")
    List<Author> findAllAuthorsWithBookReleaseDateBefore(@Param("year") Integer year);
}