package org.bookshop.services;

import org.bookshop.models.entity.Author;
import org.bookshop.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
}