package p08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Library library = new Library("lib");

        int numberOfBooks = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfBooks; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            Book currBook = new Book(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], Double.parseDouble(tokens[5]));
            library.addBook(currBook);
        }
        System.out.println(library.sortAuthorsByPrice());
    }
}