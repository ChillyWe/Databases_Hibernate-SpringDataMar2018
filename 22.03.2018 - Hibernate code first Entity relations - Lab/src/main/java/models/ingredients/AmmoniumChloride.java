package models.ingredients;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "AM")
public class AmmoniumChloride extends BaseChemicalIngredient {
    private static final String DEFAULT_AMMONIUM_CHLORIDE_NAME = "Ammonium Chloride";
    private static final String DEFAULT_AMMONIUM_CHLORIDE_PRICE = "0.59";
    private static final String DEFAULT_FORMULA = "NH4CI";

    public AmmoniumChloride() {
    }

    public AmmoniumChloride(String chemicalFormula) {
        super(DEFAULT_AMMONIUM_CHLORIDE_NAME, new BigDecimal(DEFAULT_AMMONIUM_CHLORIDE_PRICE), DEFAULT_FORMULA);
    }
}