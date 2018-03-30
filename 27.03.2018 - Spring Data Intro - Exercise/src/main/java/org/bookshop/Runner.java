package org.bookshop;

import org.bookshop.enums.AgeRestriction;
import org.bookshop.enums.EditionType;
import org.bookshop.models.entity.Author;
import org.bookshop.models.entity.Book;
import org.bookshop.models.entity.Category;
import org.bookshop.services.AuthorService;
import org.bookshop.services.BookService;
import org.bookshop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class Runner implements CommandLineRunner {
    private static final String AUTHORS_SEED_FILE_PATH = "F:\\SoftUni\\Databases Frameworks - Hibernate & Spring Data - март 2018\\27.03.2018 - Spring Data Intro - Exercise\\src\\main\\resources\\authors.txt";
    private static final String CATEGORIES_SEED_FILE_PATH = "F:\\SoftUni\\Databases Frameworks - Hibernate & Spring Data - март 2018\\27.03.2018 - Spring Data Intro - Exercise\\src\\main\\resources\\categories.txt";
    private static final String BOOK_SEED_FILE_PATH = "F:\\SoftUni\\Databases Frameworks - Hibernate & Spring Data - март 2018\\27.03.2018 - Spring Data Intro - Exercise\\src\\main\\resources\\books.txt";

    private final AuthorService authorService;
    private final BookService bookService;
    private final CategoryService categoryService;

    @Autowired
    public Runner(AuthorService authorService,
                  BookService bookService, CategoryService categoryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
//        initAuthors();
//        initCategories();
//        initBooks();
//        getAllTitlesAfter2000();
        getAllAuthorsWithReleaseBookBefore1990();

    }

    private void initAuthors() throws IOException {
        List<String> authorsStrings = Files.readAllLines(Paths.get(AUTHORS_SEED_FILE_PATH));
        List<Author> authors = authorsStrings.stream().map(
                s -> {
                    String[] authorsTokens = s.split("\\s+");
                    return new Author(authorsTokens[0], authorsTokens[1]);
                }).collect(Collectors.toList());
        authorService.saveAll(authors);
    }

    private void initCategories() throws IOException {
        List<String> categoriesStrings = Files.readAllLines(Paths.get(CATEGORIES_SEED_FILE_PATH));
        List<Category> categories = categoriesStrings.stream()
                .filter(c -> !c.isEmpty())
                .map(Category::new).collect(Collectors.toList());
        categoryService.saveAllCategories(categories);
    }

    private void initBooks() throws IOException, ParseException {
        List<String> bookStrings = Files.readAllLines(Paths.get(BOOK_SEED_FILE_PATH));
        List<Book> books = new ArrayList<>();

        List<Author> authors = authorService.getAllAuthors();
        List<Category> categories = categoryService.getAllCategories();
        Random randomForAuthors = new Random(authors.size());
        Random randomForCategories = new Random(categories.size());

        for (String line : bookStrings) {
            String[] data = line.split("\\s+");

            int authorIndex = randomForAuthors.nextInt(authors.size());
            Author author = authors.get(authorIndex);

            Set<Category> categoriesSet = generateCategories(categories, randomForCategories);


            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releaseDate = formatter.parse(data[1]);
            int copies = Integer.parseInt(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            StringBuilder titleBuilder = new StringBuilder();
            for (int i = 5; i < data.length; i++) {
                titleBuilder.append(data[i]).append(" ");
            }
            titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
            String title = titleBuilder.toString();

            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType.toString());
            book.setReleaseData(releaseDate);
            book.setCategories(categoriesSet);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction.toString());
            book.setTitle(title);

            books.add(book);
        }
        bookService.saveAllBooks(books);
    }

    private Set<Category> generateCategories(List<Category> categories, Random randomForCategories) {
        Set<Category> categoriesSet = new HashSet<>();
        int categoryIndex = randomForCategories.nextInt(categories.size());
        Category c1 = categories.get(categoryIndex);
        int nextIndex = randomForCategories.nextInt(categories.size());
        Category c2 = categories.get(nextIndex);
        int lastIndex = randomForCategories.nextInt(categories.size());
        Category c3 = categories.get(lastIndex);
        categoriesSet.add(c1);
        categoriesSet.add(c2);
        categoriesSet.add(c3);
        return categoriesSet;
    }

    private void getAllTitlesAfter2000() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date date = dateFormat.parse("2000-01-01");
        List<String> allTittlesAfterYear = this.bookService.getAllTittlesAfterYear(date);
        System.out.println(allTittlesAfterYear);
    }

    private void getAllAuthorsWithReleaseBookBefore1990() throws ParseException {
        List<Author> authors = this.authorService.getAuthorsWithBookReleaseDateBefore(1990);
        authors.forEach(a -> System.out.printf("%s %s\n", a.getFirstName(), a.getLastName()));
    }
}