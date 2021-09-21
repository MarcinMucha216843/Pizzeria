package model;

import model.interfaces.IPizza;

import java.io.Serializable;

public class Calzone extends BasePizza implements IPizza, Serializable {
    public Calzone(String additionalIngredients, String deletedIngredients) {
        this.additionalIngredients = additionalIngredients;
        this.deletedIngredients = deletedIngredients;
    }

    public void description() {
        System.out.println("Calzone, " +
                "additionalIngredients: " + additionalIngredients +
                ", deletedIngredients: " + deletedIngredients);
    }
}
