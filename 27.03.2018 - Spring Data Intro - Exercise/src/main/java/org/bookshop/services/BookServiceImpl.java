package org.bookshop.services;

import org.bookshop.models.entity.Book;
import org.bookshop.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
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
    public List<String> getAllTittlesAfterYear(Date year) {
        return bookRepository.findAllByReleaseDataAfter(year).stream().map(Book::getTitle).collect(Collectors.toList());
    }
}