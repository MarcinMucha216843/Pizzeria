package service;

import model.interfaces.IPizza;
import repository.*;

import java.io.Serializable;
import java.util.*;

public class PizzaService implements IPizzaService, Serializable {
    private IPizzaRepository pizzaRepository = new PizzaRepository();

    public ArrayList<IPizza> getAllPizzas() {
        return pizzaRepository.getAllPizzas();
    }

    public void addPizza(IPizza pizza) {
        pizzaRepository.addPizza(pizza);
    }

    public IPizza getPizza(IPizza pizza) {
        return pizzaRepository.getPizza(pizza);
    }
}
