import model.*;
import model.interfaces.IPizza;
import org.junit.Test;
import service.*;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {
    private static final int NUMBER_OF_PIZZA = 2;

    private IPizzaService pizzaService = new PizzaService();
    private IPizza pizza1 = new Margherita("cheese", "ham");
    private IPizza pizza2 = new Capriciosa("mushroom", "cheese");
    private IPizza pizza3 = new Calzone("tomato", "ham");

    @Test
    public void getAllPizzas() {
        pizzaService.addPizza(pizza1);
        pizzaService.addPizza(pizza2);
        assertFalse(pizzaService.getAllPizzas().isEmpty());
        assertTrue(NUMBER_OF_PIZZA == pizzaService.getAllPizzas().size());
    }

    @Test
    public void addPizzaTest() {
        final int repositorySize = pizzaService.getAllPizzas().size();
        pizzaService.addPizza(pizza3);
        assertTrue(repositorySize + 1 == pizzaService.getAllPizzas().size());
    }

    @Test
    public void getPizzaTest() {
        pizzaService.addPizza(pizza3);
        IPizza gottenPizza = pizzaService.getPizza(pizza3);
        assertTrue(gottenPizza == pizza3);
    }
}
