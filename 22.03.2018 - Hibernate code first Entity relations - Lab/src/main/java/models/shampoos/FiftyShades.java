package models.shampoos;

import enums.Size;
import models.BaseLabel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "FS")
public class FiftyShades extends BaseShampoo {
    private static final String DEFAULT_FRESH_NUKE_BRAND = "Fifty Shades";
    private static final BigDecimal DEFAULT_PRICE = new BigDecimal("6.69");
    private static final Size SIZE = Size.SMALL;

    public FiftyShades() {
    }

    public FiftyShades(BaseLabel label) {
        super(DEFAULT_FRESH_NUKE_BRAND, DEFAULT_PRICE, SIZE, label);
    }
}