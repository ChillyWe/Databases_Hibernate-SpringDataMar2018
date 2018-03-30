package soft_unibg.spring_advanced_query.services;

import soft_unibg.spring_advanced_query.models.entity.Author;

import java.util.List;

public interface AuthorService {

    void saveAuthor(Author author);

    void saveAll(List<Author> authors);

    List<Author> getAllAuthors();

}