package models.shampoos;

import enums.Size;
import models.BaseLabel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "PP")
public class PinkPanther extends BaseShampoo {
    private static final String DEFAULT_PINK_PANTHER_BRAND = "Pink Panther";
    private static final BigDecimal DEFAULT_PRICE = new BigDecimal("8.50");
    private static final Size SIZE = Size.MEDIUM;

    public PinkPanther() {
    }

    public PinkPanther(BaseLabel label) {
        super(DEFAULT_PINK_PANTHER_BRAND, DEFAULT_PRICE, SIZE, label);
    }
}