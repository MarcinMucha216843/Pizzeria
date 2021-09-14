package model;

import model.interfaces.IPizza;

import java.io.Serializable;

public class Capriciosa extends BasePizza implements IPizza, Serializable {
    public String additionalIngredients;
    public String deletedIngredients;

    public Capriciosa(String additionalIngredients, String deletedIngredients) {
        this.additionalIngredients = additionalIngredients;
        this.deletedIngredients = deletedIngredients;
    }

    public void description() {
        System.out.println("Capriciosa, " +
                "additionalIngredients: " + additionalIngredients +
                ", deletedIngredients: " + deletedIngredients);
    }
}
