package contacts;

public interface ChemicalIngredient extends Serializable {
    void setChemicalFormula (String chemicalFormula);

    String getChemicalFormula();
}