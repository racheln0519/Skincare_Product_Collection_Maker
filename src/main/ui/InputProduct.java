package ui;

import model.Product;
import model.ProductCollection;

import java.util.Scanner;

public class InputProduct {

    private static final String CREATE_COLLECTION_COMMAND = "create collection";
    private static final String ADD_TO_COLLECTION_COMMAND = "add product";
    private static final String REMOVE_FROM_COLLECTION_COMMAND = "remove product";
    private static final String VIEW_COLLECTION_COMMAND = "view collection";
    private static final String QUIT_COMMAND = "quit";

    private Scanner input;
    private boolean runProgram;
    private ProductCollection collection;

    public InputProduct(ProductCollection collection) {
        input = new Scanner(System.in);
        runProgram = true;
        this.collection = collection;
    }

    // EFFECTS: shows instructions at the beginning of the application
    public void handleInput() {
        System.out.println("How can I help you?");
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
                    createCollection();
                    break;
                case ADD_TO_COLLECTION_COMMAND:
                    addToCollection();
                    break;
                case REMOVE_FROM_COLLECTION_COMMAND:
                    removeFromCollection();
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

    // EFFECTS: provides user a list of commands that can be used
    private void showInstructions() {
        System.out.println("\nEnter '" + CREATE_COLLECTION_COMMAND + "' to create a skincare collection.");
        System.out.println("\nEnter '" + ADD_TO_COLLECTION_COMMAND + "' to add a product to skincare routine.");
        System.out.println("\nEnter '"
                + REMOVE_FROM_COLLECTION_COMMAND + "' to remove a product from skincare routine.");
        System.out.println("\nEnter '" + VIEW_COLLECTION_COMMAND + "' to view your skincare collection.");
        System.out.println("To quit at any time, enter '" + QUIT_COMMAND + "'.");
    }

    // MODIFIES: this
    // EFFECTS: creates a collection with prompts and user inputs
    private void createCollection() {
        System.out.println("To create a collection, please enter a name for your collection:");
        String title = input.nextLine();
        this.collection = new ProductCollection(title);
        System.out.println("Collection " + collection.getName() + " has been created.");

        showInstructions();
    }

    // EFFECTS: adds product to collection
    private void addToCollection() {
        System.out.println("Enter product name");
        String name = input.next();
        name = name + input.nextLine();
        Product newProduct = new Product(name);
        this.collection.addProduct(newProduct);
        System.out.println("Success! "
                + newProduct.getName() + " has been added to " + collection.getName() + ".");

        showInstructions();
    }

    // EFFECTS: removes product from collection
    private void removeFromCollection() {
        System.out.println("Enter product name");
        String name = input.next();
        name = name + input.nextLine();
        Product newProduct = new Product(name);

        if (collection.inCollection(newProduct)) {
            this.collection.removeProduct(newProduct);
            System.out.println("Success! "
                    + newProduct.getName() + " has been removed from " + collection.getName() + ".");
        } else {
            System.out.println(newProduct.getName() + " is not contained in " + collection.getName() + ".");
        }
        showInstructions();
    }

    // EFFECTS: lists out each product in skincare collection
    private void printCollection() {
        System.out.println("Here is your skincare collection");
        for (Product p : collection.getCollection()) {
            System.out.println(p.getName());
        }
    }

    // EFFECTS: stops taking in user input
    public void endProgram() {
        System.out.println("Quitting...");
        input.close();
    }

}
