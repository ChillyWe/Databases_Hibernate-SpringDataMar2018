package soft_unibg.spring_advanced_query;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import soft_unibg.spring_advanced_query.enums.AgeRestriction;
import soft_unibg.spring_advanced_query.enums.EditionType;
import soft_unibg.spring_advanced_query.models.entity.Author;
import soft_unibg.spring_advanced_query.models.entity.Book;
import soft_unibg.spring_advanced_query.models.entity.Category;
import soft_unibg.spring_advanced_query.services.AuthorService;
import soft_unibg.spring_advanced_query.services.BookService;
import soft_unibg.spring_advanced_query.services.CategoryService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // problem 01
//        String restrictionAge = reader.readLine();
//        printTitleOfAllBooksForThereAgeRestriction(restrictionAge);

        // problem 02
//        titlesOfTheGoldenBooksEdition();

        // problem 03
//        printTitlesByPrice();

        // problem 04
//        String year = reader.readLine();
//        printTitlesRealiseIsNotYear(year);

        // problem 05
//        String date = reader.readLine();
//        printTitlesBeforeYear(date);

        // problem 06
//        String endsWith = reader.readLine();
//        printAuthorsEndsWith(endsWith);

        // problem 07
//        String containThis = reader.readLine();
//        printBookTitleContainsGivenString(containThis);

        // problem 08
//        String startWith = reader.readLine();
//        printAuthorsLastNameStartWith(startWith);

        // problem 09
//        Integer input = Integer.parseInt(reader.readLine());
//        countBooks(input);

        // problem 10
//        totalBookCopies();

        // problem 11
//        String title = reader.readLine();
//        reducedBook(title);


        // problem 12
//        String date = reader.readLine();
//        int copiesPlus = Integer.parseInt(reader.readLine());
//        increaseBookCopiesAfterGivenDate(date, copiesPlus);

        // problem 13
        int copies = Integer.parseInt(reader.readLine());
        deleteAllWithCopiesLowerThenInt(copies);
    }

    private void deleteAllWithCopiesLowerThenInt(int copies) {
        System.out.println(bookService.deleteBooksWithCopiesUnder(copies));
    }


    private void increaseBookCopiesAfterGivenDate(String date, int copiesPlus) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date afterThisDate = dateFormat.parse(date);
        System.out.println(bookService.getCopiesAddedCount(afterThisDate, copiesPlus));
    }

    private void reducedBook(String title) {
        System.out.println(bookService.getInfoAboutBookWithTitle(title));
    }

    private void totalBookCopies() {
        System.out.println(authorService.getAllAuthorsTotalBookCopies());
    }

    private void countBooks(Integer input) {
        System.out.println(String.format("There are %d books with longer title than %d symbols"
                , this.bookService.getAllBooksWithTitleLongerThan(input)
                , input));
    }

    private void printAuthorsLastNameStartWith(String startWith) {
        System.out.println(authorService.getAllTitlesFromAuthorLastNameStartWithStr(startWith));
    }

    private void printBookTitleContainsGivenString(String containThis) {
        bookService.getAllTitlesWithContainString(containThis).forEach(System.out::println);
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

    private void printTitleOfAllBooksForThereAgeRestriction(String restriction) {
        List<String> allTitlesByAgeRestr = bookService.findAllBooksByAgeRestr(restriction.toUpperCase());
        allTitlesByAgeRestr.forEach(System.out::println);
    }

    private void titlesOfTheGoldenBooksEdition() {
        List<String> allGoldenBooksBefore5000copies = bookService.findAllGoldenBooksBefore5000copies();
        allGoldenBooksBefore5000copies.forEach(System.out::println);
    }

    private void printTitlesByPrice() {
        bookService.findBooksBetween5and40().forEach(System.out::println);
    }

    private void printTitlesRealiseIsNotYear(String year) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date date = dateFormat.parse(year + "-01-01");
        this.bookService.getAllTittlesIsNotYear(date).forEach(System.out::println);
    }

    private void printTitlesBeforeYear(String year) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = dateFormat.parse(year);
        this.bookService.getAllTittlesBeforeYear(date).forEach(System.out::println);
    }

    private void printAuthorsEndsWith(String endsWith) {
        authorService.getAllAuthorsByFirstNameEndsWith(endsWith).forEach(System.out::println);
    }
}