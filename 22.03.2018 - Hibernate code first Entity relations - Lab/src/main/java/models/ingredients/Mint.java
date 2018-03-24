package models.ingredients;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "MINT")
public class Mint extends BaseIngredient {
    private static final String DEFAULT_MINT_NAME = "Mint";
    private static final String DEFAULT_MINT_PRICE = "3.54";

    public Mint() {
    }

    public Mint(String name, BigDecimal price) {
        super(DEFAULT_MINT_NAME, new BigDecimal(DEFAULT_MINT_PRICE));

    }
}