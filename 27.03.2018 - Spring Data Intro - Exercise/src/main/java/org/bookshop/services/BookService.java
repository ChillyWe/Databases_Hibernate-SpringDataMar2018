package org.bookshop.services;

import org.bookshop.models.entity.Book;

import java.util.Date;
import java.util.List;

public interface BookService {

    void saveBook(Book book);

    void saveAllBooks(List<Book> books);

    List<String> getAllTittlesAfterYear(Date yeaar);
}