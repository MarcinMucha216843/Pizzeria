package model;

import model.interfaces.IPizza;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
    private String userName;
    private ArrayList<IPizza> pizzaList;

    public Order(String userName, ArrayList<IPizza> IPizzaList) {
        this.userName = userName;
        this.pizzaList = IPizzaList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<IPizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(ArrayList<IPizza> IPizzaList) {
        this.pizzaList = IPizzaList;
    }
}
