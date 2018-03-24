package models.ingredients;


import contacts.ChemicalIngredient;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public abstract class BaseChemicalIngredient extends BaseIngredient implements ChemicalIngredient{

    @Column(name = "chemical_formula")
    private String chemicalFormula;

    protected BaseChemicalIngredient() {
    }

    protected BaseChemicalIngredient(String name, BigDecimal price, String chemicalFormula) {
        super(name, price);
        setChemicalFormula(chemicalFormula);
    }

    @Override
    public String getChemicalFormula() {
        return this.chemicalFormula;
    }

    @Override
    public void setChemicalFormula(String chemicalFormula) {
        this.chemicalFormula = chemicalFormula;
    }
}