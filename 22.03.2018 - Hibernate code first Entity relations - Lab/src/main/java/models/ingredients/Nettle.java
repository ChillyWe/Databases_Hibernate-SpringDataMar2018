package models.ingredients;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "NET")
public class Nettle extends BaseIngredient {
    private static final String DEFAULT_NETTLE_NAME = "Nettle";
    private static final String DEFAULT_NETTLE_PRICE = "6.12";

    public Nettle() {
    }

    public Nettle(String name, BigDecimal price) {
        super(DEFAULT_NETTLE_NAME, new BigDecimal(DEFAULT_NETTLE_PRICE));
    }
}