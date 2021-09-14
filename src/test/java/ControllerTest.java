import controller.PizzaController;
import model.*;
import model.interfaces.IPizza;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
    private static final int NUMBER_OF_PIZZA = 2;

    private PizzaController pizzaController = new PizzaController();
    private IPizza pizza1 = new Margherita("cheese", "ham");
    private IPizza pizza2 = new Capriciosa("mushroom", "cheese");
    private IPizza pizza3 = new Calzone("tomato", "ham");

    @Test
    public void getAllPizzas() {
        pizzaController.addPizza(pizza1);
        pizzaController.addPizza(pizza2);
        assertFalse(pizzaController.getAllPizzas().isEmpty());
        assertTrue(NUMBER_OF_PIZZA == pizzaController.getAllPizzas().size());
    }

    @Test
    public void addPizzaTest() {
        final int repositorySize = pizzaController.getAllPizzas().size();
        pizzaController.addPizza(pizza3);
        assertTrue(repositorySize + 1 == pizzaController.getAllPizzas().size());
    }

    @Test
    public void getPizzaTest() {
        pizzaController.addPizza(pizza3);
        IPizza gottenPizza = pizzaController.getPizza(pizza3);
        assertTrue(gottenPizza == pizza3);
    }
}
