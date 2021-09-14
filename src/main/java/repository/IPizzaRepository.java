package repository;

import model.interfaces.IPizza;

import java.util.ArrayList;

public interface IPizzaRepository {
    ArrayList<IPizza> getAllPizzas();

    void addPizza(IPizza pizza);

    IPizza getPizza(IPizza pizza);
}
