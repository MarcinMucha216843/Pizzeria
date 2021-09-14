import controller.PizzaController;

import model.*;

import java.io.*;
import java.util.*;

public class Main {
    private static String userName;
    private static PizzaController pizzaController = new PizzaController();
    private static String anotherPizza;
    private static Order order;
    private static Scanner myScanner = new Scanner(System.in);

    public static void getUsername() {
        System.out.println("Hello, what's your name?");
        userName = myScanner.nextLine();
        while(userName.length() == 0) {
            System.out.println("Sorry, your username can't be empty, please try again:");
            userName = myScanner.nextLine();
        }
        System.out.println("Hello " + userName);
    }

    public static void choosePizzaType() {
        System.out.println("");
        System.out.println("What type of pizza do you want?");
        System.out.println("1 - Margherita");
        System.out.println("2 - Capriciosa");
        System.out.println("3 - Calzone");

        System.out.println("");
        System.out.println("Choose one number from the list:");
        String choose = myScanner.nextLine();
        while(!choose.equals("1") && !choose.equals("2") && !choose.equals("3")) {
            System.out.println("Sorry, you choosed wrong number, please try again:");
            choose = myScanner.nextLine();
        }

        switch(choose) {
            case "1":
                System.out.println("You choosed Margherita");
                addPizza(choose);
                break;
            case "2":
                System.out.println("You choosed Capriciosa");
                addPizza(choose);
                break;
            case "3":
                System.out.println("You choosed Calzone");
                addPizza(choose);
                break;
            default:
                System.out.println("Please try again");
                break;
        }

        System.out.println("");
        System.out.println("Do you want to order another pizza? (y/n)");
        anotherPizza = myScanner.nextLine();
    }

    public static void addPizza(String choose) {
        System.out.println("");
        System.out.println("Do you want to remove some ingredients? If yes, just write it here. If no, just press Enter:");
        String deletedIngredients = myScanner.nextLine();
        System.out.println("Removed ingredients: " + deletedIngredients);

        System.out.println("");
        System.out.println("Do you want additional ingredients? If yes, just write it here. If no, just press Enter:");
        String additionalIngredients = myScanner.nextLine();
        System.out.println("Additional ingredients: " + additionalIngredients);

        if(choose.equals("1")) {
            pizzaController.addPizza(new Margherita(additionalIngredients, deletedIngredients));
        } else if(choose.equals("2")) {
            pizzaController.addPizza(new Capriciosa(additionalIngredients, deletedIngredients));
        } else if(choose.equals("3")) {
            pizzaController.addPizza(new Calzone(additionalIngredients, deletedIngredients));
        }

        order = new Order(userName, pizzaController.getAllPizzas());

        orderSummary(order);
    }

    public static void orderSummary(Order order) {
        System.out.println("");
        System.out.println("ORDER SUMMARY");
        System.out.println("Order for: " + order.getUserName());
        System.out.println("Choosed pizzas: ");
        for(int i = 0; i < order.getPizzaList().size(); i++) {
            order.getPizzaList().get(i).description();
        }
    }

    public static void anotherPizza() {
        while(anotherPizza.equals("y")) {
            choosePizzaType();
        }
    }

    public static void goodbyeMessage() {
        System.out.println("");
        System.out.println("Thank you for choosing our pizzeria, have a nice day");
    }

    public static void writeToFile(Object serObj) throws IOException {
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream("order.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();

        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fileOut != null)
                fileOut.close();
        }

        // checking if deserialization works
        List<Order> results = new ArrayList<Order>();
        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream("order.txt");
            ObjectInputStream ois = new ObjectInputStream(fileIn);
            results.add((Order) ois.readObject());
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (EOFException | ClassNotFoundException ignored) {
            ignored.printStackTrace();
        } finally {
            if (fileIn != null)
                fileIn.close();
        }

        System.out.println("");
        System.out.println("DESERIALIZED");

        for(int i = 0; i < results.size(); i++) {
            System.out.println("Username: " + results.get(i).getUserName());
            for(int j = 0; j < results.get(i).getPizzaList().size(); j++) {
                results.get(i).getPizzaList().get(j).description();
            }
        }
    }

    public static void main(String args[]) throws IOException {
        getUsername();
        choosePizzaType();
        anotherPizza();
        writeToFile(order);
        goodbyeMessage();
    }
}