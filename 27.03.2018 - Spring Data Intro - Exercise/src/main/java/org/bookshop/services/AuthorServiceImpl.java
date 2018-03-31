package org.bookshop.services;

import org.bookshop.models.entity.Author;
import org.bookshop.models.entity.Book;
import org.bookshop.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
    public List<Author> getAuthorsWithBookReleaseDateBefore(Integer year) {
        return this.authorRepository.findAllAuthorsWithBookReleaseDateBefore(year);
    }

    @Override
    public List<String> getAuthorsOrderByBookCount() {
        List<String> authors = new ArrayList<>();
        this.authorRepository.findAll().stream()
                .sorted((a, b)-> Integer.compare(b.getBooks().size(), a.getBooks().size()))
                .forEach(a -> {
                    String authorStr = String.format("Author: %s %s ---> %d books"
                            , a.getFirstName(), a.getLastName(), a.getBooks().size());
                    authors.add(authorStr);
                });
        return authors;
    }

    @Override
    public List<String> getAuthorBooks(String firstName, String lastName) {
        List<String> books = new ArrayList<>();
        authorRepository.findByFirstNameAndLastName(firstName, lastName).getBooks()
                .stream().sorted(Comparator.comparing(Book::getReleaseData).reversed().thenComparing(Book::getTitle))
        .forEach(book -> {
            String bookStr = String.format("%s ---> %s ---> %d copies", book.getTitle(), book.getReleaseData().toString(), book.getCopies());
            books.add(bookStr);
        });
        return books;
    }
}