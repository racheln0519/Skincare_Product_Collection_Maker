package ui;

import model.Person;
import model.Product;

import java.util.Collection;
import java.util.Scanner;

public class InputProduct {

    private static final String CREATE_COLLECTION_COMMAND = "create collection";
    private static final String ADD_PRODUCT_COMMAND = "add";
    private static final String QUIT_COMMAND = "quit";

    private Scanner input;
    private boolean runProgram;
    private Collection collection;
    private Person p;

    public InputProduct(Collection collection) {
        input = new Scanner(System.in);
        runProgram = true;
        this.collection = collection;
    }

    public void handleInput() {
        System.out.println("Hello! How can I help you?");
        showInstructions();
    }

    private void showInstructions() {
        System.out.println("\nEnter '" + CREATE_COLLECTION_COMMAND + " to create a skincare collection.");
        if (p == null) {
            System.out.println("Enter '" + );
        }

        System.out.println("To quit at any time, enter " + QUIT_COMMAND + ".");
    }

    private void handleAddToCollection(Product product) {
        System.out.println("To create a collection, please enter your name");

        String name = input.nextLine();
        p = new Person(name);
        System.out.println("Please choose one of the following: 'add' to add a product or 'remove' to remove a product");
        String operation = input.next();

        if (operation.equals("add")) {
            collection.add(product);
        }
    }

    // EFFECTS: stops taking in user input
    public void endProgram() {
        System.out.println("Quitting...");
        input.close();
    }



}
