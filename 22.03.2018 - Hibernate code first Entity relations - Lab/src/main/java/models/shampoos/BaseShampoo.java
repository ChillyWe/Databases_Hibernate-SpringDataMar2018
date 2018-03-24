package models.shampoos;

import contacts.Shampoo;
import enums.Size;
import models.BaseLabel;
import models.ingredients.BaseIngredient;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shampoos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "shampoo_type", discriminatorType = DiscriminatorType.STRING)
public abstract class BaseShampoo implements Shampoo {
    @Id
    private long id;

    @Basic
    private String brand;

    @Basic
    private BigDecimal price;

    @Enumerated
    private Size size;

    @OneToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "label", referencedColumnName = "id")
    private BaseLabel label;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "shampoos_ingredients",
            joinColumns = @JoinColumn(name = "shampoo_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"))
    private Set<BaseIngredient> ingredients;

    public BaseShampoo() {
        this.ingredients = new HashSet<>();
    }

    public BaseShampoo(String brand, BigDecimal price, Size size, BaseLabel label) {
        setBrand(brand);
        setPrice(price);
        setSize(size);
        setLabel(label);
        this.ingredients = new HashSet<>();
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public Size getSize() {
        return this.size;
    }

    @Override
    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public BaseLabel getLabel() {
        return this.label;
    }

    @Override
    public void setLabel(BaseLabel label) {
        this.label = label;
    }

    @Override
    public Set<BaseIngredient> getIngredients() {
        return this.ingredients;
    }

    @Override
    public void setIngredient(Set<BaseIngredient> ingredients) {
        this.ingredients = ingredients;
    }
}