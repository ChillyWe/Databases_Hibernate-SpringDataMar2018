package contacts;

import models.shampoos.BaseShampoo;

import java.math.BigDecimal;
import java.util.List;

public interface Ingredient {
    int getId();

    String getName();

    void setName(String name);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    List<BaseShampoo> getShampoos();

    void setShampoos(List<BaseShampoo> shampoos);
}