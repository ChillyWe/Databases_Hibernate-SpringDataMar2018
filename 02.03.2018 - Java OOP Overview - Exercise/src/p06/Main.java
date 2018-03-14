package p06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> persons = new LinkedHashMap<>();
        Map<String, Product> products = new HashMap<>();

        try {
            String[] personsInput = reader.readLine().split(";");
            fillPersons(persons, personsInput);

            String[] productsInput = reader.readLine().split(";");
            fillProducts(products, productsInput);

            String line;
            while (!"END".equalsIgnoreCase(line = reader.readLine())) {
                String[] tokens = line.split("\\s+");
                String personName = tokens[0];
                String productName = tokens[1];

                System.out.println(persons.get(personName).buyProduct(products.get(productName)));
            }

            for (Person person : persons.values()) {
                System.out.println(person);
            }
        }
        catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static void fillProducts(Map<String, Product> products, String[] productsInput) {
        for (String inputToken : productsInput) {
            String[] tokens = inputToken.split("=");
            Product currProduct = new Product(tokens[0].trim(), Integer.parseInt(tokens[1]));
            products.put(tokens[0].trim(), currProduct);
        }
    }

    private static void fillPersons(Map<String, Person> persons, String[] personsInput) {
        for (String inputToken : personsInput) {
            String[] tokens = inputToken.split("=");
            Person currPerson = new Person(tokens[0].trim(), Integer.parseInt(tokens[1]));
            persons.put(tokens[0].trim(), currPerson);
        }
    }
}