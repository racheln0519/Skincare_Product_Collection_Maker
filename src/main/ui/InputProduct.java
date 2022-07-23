package ui;

import model.Person;
import model.Product;
//import model.ProductType;

import java.util.Collection;
import java.util.Scanner;

public class InputProduct {

    private static final String CREATE_COLLECTION_COMMAND = "create collection";
    private static final String VIEW_COLLECTION_COMMAND = "view collection";
    private static final String QUIT_COMMAND = "quit";

    private Scanner input;
    private boolean runProgram;
    private Collection collection;
    private Person person;

    public InputProduct(Collection collection) {
        input = new Scanner(System.in);
        runProgram = true;
        // this.collection = collection;
    }

    public void handleInput() {
        System.out.println("Hello! How can I help you?");
        showInstructions();
        String string;

        while (runProgram) {
            if (input.hasNext()) {
                string = input.nextLine();
                parseInput(string);
            }
        }
    }

    // EFFECTS: prints menu options and info depending on the input
    private void parseInput(String string) {
        if (string.length() > 0) {
            switch (string) {
                case CREATE_COLLECTION_COMMAND:
                    handleAddToCollection();
                    break;
                case VIEW_COLLECTION_COMMAND:
                    printCollection();
                    break;
                case QUIT_COMMAND:
                    runProgram = false;
                    break;
                default:
                    System.out.println("Sorry, this command is not recognized. Please try again.");
                    break;
            }
        }

    }


    private void showInstructions() {
        System.out.println("\nEnter '" + CREATE_COLLECTION_COMMAND + " to create a skincare collection.");
        System.out.println("To quit at any time, enter " + QUIT_COMMAND + ".");
    }

    // MODIFIES: this
    // EFFECTS: creates a collection with prompts and user inputs
    private void handleAddToCollection(Product product) {
        System.out.println("To create a collection, please enter a collection name:");

        String name = input.nextLine();
        collection = new Collection(name);
        System.out.println("Please choose from the following: 'add' to add a product or 'remove' to remove a product.");
        String operation = input.next();

        if (operation.equals("add")) {
            System.out.println("Enter product name");
            String pname = input.nextLine();
            System.out.println("Enter product type");
            String ptype = input.nextLine();
            System.out.println("Enter product description");
            String pdescription = input.nextLine();
            Product newProduct = new Product(pname, ptype, pdescription);
            collection.add(newProduct);
            System.out.println("Confirmed. " + p.getName() + " has added " + product + " to their collection.");
            showInstructions();

        } else if (operation.equals("remove")) {
            System.out.println("Enter product name");
            String pname = input.nextLine();
            System.out.println("Enter product type");
            String ptype = input.nextLine();
            System.out.println("Enter product description");
            String pdescription = input.nextLine();
            Product newProduct = new Product(pname, ptype, pdescription);
            collection.remove(newProduct);
            System.out.println("Confirmed. " + p.getName() + " has removed " + product + " from their collection.");

        }

        showInstructions();
    }

    private void printCollection() {
        System.out.println("Here is your skincare collection");
        for (Product p: collection) {
            System.out.println(p.getClass().getSimpleName());
        }
        showInstructions();
    }


    // EFFECTS: stops taking in user input
    public void endProgram() {
        System.out.println("Quitting...");
        input.close();
    }

}
