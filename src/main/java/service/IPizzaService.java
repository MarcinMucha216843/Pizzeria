package service;

import model.interfaces.IPizza;

import java.util.ArrayList;

public interface IPizzaService {
    ArrayList<IPizza> getAllPizzas();

    void addPizza(IPizza pizza);

    IPizza getPizza(IPizza pizza);
}
