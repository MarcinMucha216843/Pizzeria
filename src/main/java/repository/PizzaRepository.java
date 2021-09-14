package repository;

import model.interfaces.IPizza;
import java.util.*;

public class PizzaRepository implements IPizzaRepository {
    private ArrayList<IPizza> pizzaList = new ArrayList<IPizza>();

    public ArrayList<IPizza> getAllPizzas() {
        return pizzaList;
    }

    public void addPizza(IPizza pizza) {
        pizzaList.add(pizza);
    }

    public IPizza getPizza(IPizza pizza) {
        if (pizzaList.contains(pizza)) {
            return pizza;
        } else {
            return null;
        }
    }
}
