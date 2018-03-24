package contacts;

import enums.Size;
import models.BaseLabel;
import models.ingredients.BaseIngredient;

import java.math.BigDecimal;
import java.util.Set;

public interface Shampoo {
    String getBrand();

    void setBrand(String brand);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    Size getSize();

    void setSize(Size size);

    BaseLabel getLabel();

    void setLabel(BaseLabel label);

    Set<BaseIngredient> getIngredients();

    void setIngredient(Set<BaseIngredient> ingredients);
}