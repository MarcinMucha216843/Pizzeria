package model;

import java.io.Serializable;

public abstract class BasePizza implements Serializable {
    public String additionalIngredients;
    public String deletedIngredients;

    public void setAdditionalIngredients(String additionalIngredients) {
        this.additionalIngredients = additionalIngredients;
    }

    public String getAdditionalIngredients() {
        return additionalIngredients;
    }

    public void setDeletedIngredients(String deletedIngredients) {
        this.deletedIngredients = deletedIngredients;
    }

    public String getDeletedIngredients() {
        return deletedIngredients;
    }
}
