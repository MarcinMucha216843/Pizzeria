package model;

import model.interfaces.IPizza;

import java.io.Serializable;

public class Margherita extends BasePizza implements IPizza, Serializable {
    public String additionalIngredients;
    public String deletedIngredients;

    public Margherita(String additionalIngredients, String deletedIngredients) {
        this.additionalIngredients = additionalIngredients;
        this.deletedIngredients = deletedIngredients;
    }

    public void description() {
        System.out.println("Margherita, " +
                "additionalIngredients: " + additionalIngredients +
                ", deletedIngredients: " + deletedIngredients);
    }
}
