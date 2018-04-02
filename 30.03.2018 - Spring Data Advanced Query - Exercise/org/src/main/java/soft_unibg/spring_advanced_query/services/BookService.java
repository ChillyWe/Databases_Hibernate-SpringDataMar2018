package soft_unibg.spring_advanced_query.services;

import soft_unibg.spring_advanced_query.models.entity.Book;

import java.util.Date;
import java.util.List;

public interface BookService {

    void saveBook(Book book);

    void saveAllBooks(List<Book> books);

    List<String> findAllBooksByAgeRestr(String restriction);

    List<String> findAllGoldenBooksBefore5000copies();

    List<String> findBooksBetween5and40();

    List<String> getAllTittlesIsNotYear(Date year);

    List<String> getAllTittlesBeforeYear(Date year);

    List<String> getAllTitlesWithContainString(String containThis);

    Integer getAllBooksWithTitleLongerThan(Integer symbolCount);
}