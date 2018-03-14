package p08;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public String sortAuthorsByPrice() {
        Map<String, Double> authors = new TreeMap<>();
        StringBuilder sb = new StringBuilder();

        for (Book book : this.books) {
            String name = book.getAuthor();
            double price = book.getPrice();
            if (authors.containsKey(name)) {
                authors.put(name, authors.get(name) + price);
            }
            authors.putIfAbsent(name, price);
        }
        authors.entrySet().stream().sorted((a1, a2) -> a2.getValue().compareTo(a1.getValue()))
                .forEach(a -> sb.append(String.format("%s -> %.2f", a.getKey(), a.getValue())).append(System.lineSeparator()));

        return sb.toString().trim().replace(",", ".");
    }
}