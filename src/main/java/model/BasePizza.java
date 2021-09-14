package model;

public abstract class BasePizza {
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
