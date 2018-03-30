package org.bookshop.services;

import org.bookshop.models.entity.Author;

import java.util.List;

public interface AuthorService {

    void saveAuthor(Author author);

    void saveAll(List<Author> authors);

    List<Author> getAllAuthors();

    List<Author> getAuthorsWithBookReleaseDateBefore(Integer year);
}