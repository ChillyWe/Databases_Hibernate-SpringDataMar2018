package models.shampoos;

import enums.Size;
import models.BaseLabel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "FN")
public class FreshNuke extends BaseShampoo {
    private static final String DEFAULT_FRESH_NUKE_BRAND = "Fresh Nuke";
    private static final BigDecimal DEFAULT_PRICE = new BigDecimal("9.33");
    private static final Size SIZE = Size.LARGE;

    public FreshNuke() {
    }

    public FreshNuke(BaseLabel label) {
        super(DEFAULT_FRESH_NUKE_BRAND, DEFAULT_PRICE, SIZE, label);
    }
}