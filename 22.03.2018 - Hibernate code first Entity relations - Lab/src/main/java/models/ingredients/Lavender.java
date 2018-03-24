package models.ingredients;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "LAV")
public class Lavender extends BaseIngredient {
    private static final String DEFAULT_LAVENDER_NAME = "Lavender";
    private static final String DEFAULT_LAVENDER_PRICE = "2";

    public Lavender() {
    }

    public Lavender(String name, BigDecimal price) {
        super(DEFAULT_LAVENDER_NAME, new BigDecimal(DEFAULT_LAVENDER_PRICE));
    }
}