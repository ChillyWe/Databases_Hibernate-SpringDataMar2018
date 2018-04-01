package soft_unibg.spring_advanced_query.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft_unibg.spring_advanced_query.models.entity.Author;
import soft_unibg.spring_advanced_query.repositories.AuthorRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
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
    public List<String> getAllAuthorsByFirstNameEndsWith(String endsWith) {
        List<String> result = new ArrayList<>();
        authorRepository.findAuthorByFirstNameEndingWith(endsWith)
                .forEach(author -> {
                    String format = String.format("%s %s", author.getFirstName(), author.getLastName());
                    result.add(format);
                });
        return result;
    }
}