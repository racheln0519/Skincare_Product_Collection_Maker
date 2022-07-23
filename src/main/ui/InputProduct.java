package ui;

import model.Product;
import model.ProductCollection;

import java.util.Collection;
import java.util.Scanner;

public class InputProduct {

    private static final String CREATE_COLLECTION_COMMAND = "create collection";
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
        System.out.println("\nEnter '" + CREATE_COLLECTION_COMMAND + "' to create a skincare collection.");
        System.out.println("\nEnter '" + VIEW_COLLECTION_COMMAND + "' to view your skincare collection.");
        System.out.println("To quit at any time, enter '" + QUIT_COMMAND + "'.");
    }

    // MODIFIES: this
    // EFFECTS: creates a collection with prompts and user inputs
    @SuppressWarnings("methodlength")
    private void handleAddToCollection() {
        System.out.println("To create a collection, please enter a name for your collection:");

        String namegiven = input.nextLine();
        collection = new ProductCollection(namegiven);
        System.out.println("Please choose from the following: 'add' to add a product or 'remove' to remove a product.");
        String operation = input.next();

        if (operation.equals("add")) {
            System.out.println("Enter product name");
            String name = input.nextLine();
            System.out.println("Enter product type");
            String type = input.nextLine();
            System.out.println("Enter product description");
            String description = input.nextLine();
            Product newProduct = new Product(name, type, description);
            collection.addProduct(newProduct);
            System.out.println("Success! " + newProduct + " has been added to " + namegiven + ".");
            showInstructions();

        } else if (operation.equals("remove")) {
            System.out.println("Enter product name");
            String name = input.nextLine();
            System.out.println("Enter product type");
            String type = input.nextLine();
            System.out.println("Enter product description");
            String description = input.nextLine();
            Product newProduct = new Product(name, type, description);

            if (collection.inCollection(newProduct)) {
                collection.removeProduct(newProduct);
                System.out.println("Success! " + name + " has been removed from " + namegiven + ".");

            } else {
                System.out.println("This product is not in your collection.");
            }
        }
        showInstructions();
    }

    private void printCollection() {
        System.out.println("Here is your skincare collection");
        System.out.println(collection);
    }

    // EFFECTS: stops taking in user input
    public void endProgram() {
        System.out.println("Quitting...");
        input.close();
    }

}
