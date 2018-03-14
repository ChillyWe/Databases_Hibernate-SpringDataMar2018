package p10;

public class BeerCounter {
    private static int beersInStock = 0;
    private static int beersDrank = 0;

    public BeerCounter() {
    }

    public int getBeersInStock() {
        return beersInStock;
    }

    public int getBeersDrank() {
        return beersDrank;
    }

    public static void buyBeer(int newBeers) {
        BeerCounter.beersInStock += newBeers;
    }

    public static void drinkBeer (int beersToDrank) {
        BeerCounter.beersInStock -= beersToDrank;
        BeerCounter.beersDrank += beersToDrank;
    }
}