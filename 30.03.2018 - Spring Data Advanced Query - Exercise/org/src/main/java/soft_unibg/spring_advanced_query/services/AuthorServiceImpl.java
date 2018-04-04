package soft_unibg.spring_advanced_query.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft_unibg.spring_advanced_query.models.entity.Author;
import soft_unibg.spring_advanced_query.models.entity.Book;
import soft_unibg.spring_advanced_query.repositories.AuthorRepository;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void saveAuthor(Author author) {
        authorRepository.saveAndFlush(author);
    }

    @Override
    public void saveAll(List<Author> authors) {
        authorRepository.saveAll(authors);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public List<String> getAllAuthorsByFirstNameEndsWith(String endsWith) {
        List<String> result = new ArrayList<>();
        authorRepository.findAuthorByFirstNameEndingWith(endsWith)
                .forEach(author -> {
                    String format = String.format("%s %s", author.getFirstName(), author.getLastName());
                    result.add(format);
                });
        return result;
    }

    @Override
    public String getAllTitlesFromAuthorLastNameStartWithStr(String startWith) {
        StringBuilder builder = new StringBuilder();
        authorRepository.findAuthorByLastNameStartingWith(startWith)
                .forEach(a -> {
                    Set<Book> books = a.getBooks();
                    books.forEach(book -> builder.append(book.getTitle())
                            .append(" (").append(a.getFirstName()).append(" ").append(a.getLastName()).append(")")
                            .append(System.lineSeparator()));
                });
        return builder.toString();
    }

    @Override
    public String getAllAuthorsTotalBookCopies() {
        StringBuilder builder = new StringBuilder();
        Map<Author, Integer> authorsByCopies = new HashMap<>();

        authorRepository.findAll().forEach(author -> {
            int numberOfCopies = author.getBooks().stream().mapToInt(Book::getCopies).sum();
            authorsByCopies.putIfAbsent(author, numberOfCopies);
        });

        authorsByCopies.entrySet().stream()
                .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                .forEach(authorIntegerEntry -> {
                    builder.append(authorIntegerEntry.getKey().getFirstName()).append(" ")
                            .append(authorIntegerEntry.getKey().getLastName()).append(" - ")
                            .append(authorIntegerEntry.getValue()).append(System.lineSeparator());
                });
        return builder.toString();
    }
}