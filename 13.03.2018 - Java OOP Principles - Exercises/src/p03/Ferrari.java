package p03;

/**
 * Created by Chilly on 18.11.2017 г..
 */
public class Ferrari implements Car{
    public static final String FERRARI_SPIDER_DEFAULT = "488-Spider";

    private String model;
    private String driver;

    public Ferrari(String driver) {
        this.driver = driver;
        this.model = FERRARI_SPIDER_DEFAULT;
    }

    public String getModel() {
        return this.model;
    }

    public String getDriver() {
        return this.driver;
    }

    @Override
    public String useBrakes() {
        return "Brakes!";
    }

    @Override
    public String useGasPedal() {
        return "Zadu6avam sA!";
    }
}