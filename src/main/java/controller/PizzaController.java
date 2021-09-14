package controller;

import model.interfaces.IPizza;
import service.*;

import java.io.Serializable;
import java.util.ArrayList;

public class PizzaController implements Serializable {
    private IPizzaService pizzaService = new PizzaService();

    public void addPizza(IPizza pizza) {
        pizzaService.addPizza(pizza);
    }

    public ArrayList<IPizza> getAllPizzas() {
        return pizzaService.getAllPizzas();
    }

    public IPizza getPizza(IPizza pizza) {
        return pizzaService.getPizza(pizza);
    }
}
