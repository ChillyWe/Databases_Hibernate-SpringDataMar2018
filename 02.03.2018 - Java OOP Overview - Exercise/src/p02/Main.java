package p02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> phrases = Arrays.asList("Excellent product.", "Such a great product.", "I always use that product.",
                "Best product of its category.", "Exceptional product.", "I can’t live without this product.");
        List<String> events = Arrays.asList("Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!");
        List<String> author = Arrays.asList("Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva");
        List<String> cities = Arrays.asList("Burgas", "Sofia", "Plovdiv", "Varna", "Ruse");
        Random random = new Random();

        int magicNum = Integer.parseInt(reader.readLine());

        while (magicNum-- > 0) {
            String currPhrase = phrases.get(random.nextInt(phrases.size()));
            String currEvent = events.get(random.nextInt(events.size()));
            String currAuthor = author.get(random.nextInt(author.size()));
            String currCity = cities.get(random.nextInt(cities.size()));
            System.out.println(String.format("%s %s %s – %s.", currPhrase, currEvent, currAuthor, currCity));
        }

    }
}