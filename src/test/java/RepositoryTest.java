import model.*;
import model.interfaces.IPizza;
import org.junit.Test;
import repository.*;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryTest {
    private static final int NUMBER_OF_PIZZA = 2;

    private IPizzaRepository pizzaRepository = new PizzaRepository();
    private IPizza pizza1 = new Margherita("cheese", "ham");
    private IPizza pizza2 = new Capriciosa("mushroom", "cheese");
    private IPizza pizza3 = new Calzone("tomato", "ham");

    @Test
    public void getAllPizzas() {
        pizzaRepository.addPizza(pizza1);
        pizzaRepository.addPizza(pizza2);
        assertFalse(pizzaRepository.getAllPizzas().isEmpty());
        assertTrue(NUMBER_OF_PIZZA == pizzaRepository.getAllPizzas().size());
    }

    @Test
    public void addPizzaTest() {
        final int repositorySize = pizzaRepository.getAllPizzas().size();
        pizzaRepository.addPizza(pizza3);
        assertTrue(repositorySize + 1 == pizzaRepository.getAllPizzas().size());
    }

    @Test
    public void getPizzaTest() {
        pizzaRepository.addPizza(pizza3);
        IPizza gottenPizza = pizzaRepository.getPizza(pizza3);
        assertTrue(gottenPizza == pizza3);
    }
}
