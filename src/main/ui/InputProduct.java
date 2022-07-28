package ui;

import model.Product;
import model.ProductCollection;

import java.util.Scanner;

public class InputProduct {

    private static final String CREATE_COLLECTION_COMMAND = "create collection";
    private static final String SET_SAVE_MONEY_PREFERENCE_COMMAND = "save money";
    private static final String ADD_TO_COLLECTION_COMMAND = "add product";
    private static final String REMOVE_FROM_COLLECTION_COMMAND = "remove product";
    private static final String VIEW_COLLECTION_COMMAND = "view collection";
    private static final String QUIT_COMMAND = "quit";

    private Scanner input;
    private boolean runProgram;
    private ProductCollection myProductCollection;

    public InputProduct(ProductCollection collection) {
        input = new Scanner(System.in);
        runProgram = true;
        this.myProductCollection = collection;
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
    @SuppressWarnings("methodlength")
    private void parseInput(String string) {
        if (string.length() > 0) {
            switch (string) {
                case CREATE_COLLECTION_COMMAND:
                    createCollection();
                    break;
                case SET_SAVE_MONEY_PREFERENCE_COMMAND:
                    setMoneySavingPreference();
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
        System.out.println("\nEnter '" + ADD_TO_COLLECTION_COMMAND + "' to add a product to skincare collection.");
        System.out.println("\nEnter '"
                + REMOVE_FROM_COLLECTION_COMMAND + "' to remove a product from skincare collection.");
        System.out.println("\nEnter '"
                + SET_SAVE_MONEY_PREFERENCE_COMMAND + "' to set money saving preference.");
        System.out.println("\nEnter '" + VIEW_COLLECTION_COMMAND + "' to view your skincare collection.");
        System.out.println("To quit at any time, enter '" + QUIT_COMMAND + "'.");
    }

    // MODIFIES: this
    // EFFECTS: creates a collection with prompts and user inputs
    private void createCollection() {
        System.out.println("To create a collection, please enter a name for your collection:");
        String title = input.nextLine();
        this.myProductCollection = new ProductCollection(title);
        System.out.println("Collection " + myProductCollection.getName() + " has been created.");

        showInstructions();
    }

    // EFFECTS: adds product to collection
    private void addToCollection() {
        System.out.println("Enter product name");
        String name = input.next();
        name = name + input.nextLine();
        Product newProduct = new Product(name);
        if (!myProductCollection.savemoney()) {
            this.myProductCollection.addProduct(newProduct);
            System.out.println("Success! "
                    + newProduct.getName() + " has been added to " + myProductCollection.getName() + ".");
        } else {
            System.out.println("Sorry, can't add " + newProduct.getName()
                    + " to " + myProductCollection.getCollection() + " because user is saving money");
        }
        showInstructions();
    }

    // EFFECTS: removes product from collection
    private void removeFromCollection() {
        System.out.println("Enter product name");
        String name = input.next();
        name = name + input.nextLine();
        for (Product product: myProductCollection.getCollection()) {
            if (name.equals(product.getName())) {
                myProductCollection.removeProduct(product);
                System.out.println("Success! "
                        + product.getName() + " has been removed from " + myProductCollection.getName() + ".");
            }
        }
        showInstructions();
    }

    // EFFECTS: sets savemoney to saving money or not saving money
    private void setMoneySavingPreference() {
        System.out.println("Would you like to set your preference to 'save money' or 'not saving money'?");
        String preference = input.next();
        preference = preference + input.nextLine();
        if (preference.equals("save money")) {
            myProductCollection.savingMoney();
            System.out.println("Money saving preference has been set to 'saving money'.");
        }
        if (preference.equals("not saving money")) {
            myProductCollection.notSavingMoney();
            System.out.println("Money saving preference has been set to 'not saving money'");
        }
        if (!preference.equals("save money") && !preference.equals("not saving money")) {
            System.out.println("Sorry, this command is not recognized. Please try again.");
        }
        showInstructions();
    }


    // EFFECTS: lists out each product in skincare collection
    private void printCollection() {
        System.out.println("Here is your skincare collection");
        for (Product p : myProductCollection.getCollection()) {
            System.out.println(p.getName());
        }
    }

    // EFFECTS: stops taking in user input
    public void endProgram() {
        System.out.println("Quitting...");
        input.close();
    }

}
