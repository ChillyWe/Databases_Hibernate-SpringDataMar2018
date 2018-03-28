package entities;


import java.math.BigDecimal;

public interface Vehicle {
    String getManufacturer();
    String getModel();
    BigDecimal getPrice();
    Integer getMaxSpeed();
}

