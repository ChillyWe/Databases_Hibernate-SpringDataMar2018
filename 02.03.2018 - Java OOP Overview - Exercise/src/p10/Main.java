package p10;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        BeerCounter beerCounter = new BeerCounter();

        try {
            String line = reader.nextLine();
            while (!"end".equalsIgnoreCase(line)) {
                int[] beers = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
                BeerCounter.buyBeer(beers[0]);
                BeerCounter.drinkBeer(beers[1]);

                if (reader.hasNextLine()) {
                    line = reader.nextLine();
                } else {
                    break;
                }
            }
        } catch (Exception ignoreThisExp) {

        }
        System.out.println(String.format("%d %d", beerCounter.getBeersInStock(), beerCounter.getBeersDrank()));
    }
}