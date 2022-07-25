package model;

import java.util.ArrayList;
import java.util.List;

public class ProductCollection {
    private String name;
    private List<Product> collection;
    private boolean savemoney;


    // EFFECTS: constructs an empty collection with given name
    public ProductCollection(String name) {
        this.name = name;
        collection = new ArrayList<>();
        savemoney = false;
    }

    // getters
    public String getName() {
        return name;
    }

    public List<Product> getCollection() {
        return collection;
    }

    public boolean savemoney() {
        return savemoney;
    }

    // MODIFIES: this
    // EFFECTS: sets a field in this collection such that the user is saving money
    public void savingMoney() {
        savemoney = true;
    }

    // MODIFIES: this
    // EFFECTS: sets a field in this collection such that the user is not saving money
    public void notSavingMoney() {
        savemoney = false;
    }

    // MODIFIES: this
    // EFFECTS: adds a skincare product to collection if product is not contained in the collection and if user is not
    // saving money; false otherwise
    public boolean addProduct(Product product) {
        if (!savemoney) {
            if (!collection.contains(product)) {
                collection.add(product);
                return true;
            }
        }
        return false;
    }

    // MODIFIES: this
    // EFFECTS: removes a skincare product from collection if it is contained in the collection
    public boolean removeProduct(Product product) {
        if (collection.contains(product)) {
            collection.remove(product);
            return true;
        }
        return false;
    }

    // EFFECTS: returns true if the given product is contained in the collection; false otherwise
    public boolean inCollection(Product product) {
        return collection.contains(product);
    }

    // EFFECTS: returns true if collection is empty; false otherwise
    public boolean isEmpty() {
        return collection.isEmpty();
    }

    // EFFECTS: produces the size of the collection
    public int collectionSize() {
        return collection.size();
    }



}
