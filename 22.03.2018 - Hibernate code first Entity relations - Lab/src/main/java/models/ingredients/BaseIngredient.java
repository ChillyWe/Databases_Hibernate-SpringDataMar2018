package models.ingredients;

import contacts.Ingredient;
import contacts.Shampoo;
import models.shampoos.BaseShampoo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "ingredients")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ingredient_type")
public abstract class BaseIngredient implements Ingredient {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToMany(mappedBy = "ingredients", cascade = CascadeType.ALL)
    private List<BaseShampoo> shampoos;

    protected BaseIngredient() {
    }

    protected BaseIngredient(String name, BigDecimal price) {
        setName(name);
        setPrice(price);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }


    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public List<BaseShampoo> getShampoos() {
        return this.shampoos;
    }

    @Override
    public void setShampoos(List<BaseShampoo> shampoos) {
        this.shampoos = shampoos;
    }
}