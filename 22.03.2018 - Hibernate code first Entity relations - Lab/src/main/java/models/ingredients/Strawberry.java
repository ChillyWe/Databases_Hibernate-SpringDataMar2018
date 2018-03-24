package models.ingredients;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "STRAWS")
public class Strawberry extends BaseIngredient {
    private static final String DEFAULT_STRAWBERRY_NAME = "Strawberry";
    private static final String DEFAULT_STRAWBERRY_PRICE = "4.85";

    public Strawberry() {
    }

    public Strawberry(String name, BigDecimal price) {
        super(DEFAULT_STRAWBERRY_NAME, new BigDecimal(DEFAULT_STRAWBERRY_PRICE));
    }
}