package soft_unibg.spring_advanced_query.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft_unibg.spring_advanced_query.models.entity.Book;
import soft_unibg.spring_advanced_query.repositories.BookRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.saveAndFlush(book);
    }

    @Override
    public void saveAllBooks(List<Book> books) {
        bookRepository.saveAll(books);
    }

    @Override
    public List<String> findAllBooksByAgeRestr(String restriction) {
        return bookRepository.findBooksByAgeRestriction(restriction).stream()
                .map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<String> findAllGoldenBooksBefore5000copies() {
        return bookRepository.findBooksByCopiesBefore(5000)
                .stream().map(Book::getTitle).collect(Collectors.toList());
    }
}