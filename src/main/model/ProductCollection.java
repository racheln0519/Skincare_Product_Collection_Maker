package model;

import java.util.ArrayList;
import java.util.List;

public class ProductCollection {
    private String name;
    private List<Product> collection;


    // EFFECTS: constructs an empty collection with given name
    public ProductCollection(String name) {
        this.name = name;
        collection = new ArrayList<>();
    }

    // getters
    public String getName() {
        return name;
    }

    public List<Product> getCollection() {
        return collection;
    }

    // MODIFIES: this
    // EFFECTS: adds a skincare product to collection
    public void addProduct(Product product) {
        collection.add(product);
    }

    // MODIFIES: this
    // EFFECTS: removes a skincare product from collection
    public void removeProduct(Product product) {
        collection.remove(product);
    }

    // EFFECTS: checks to see if the given product is contained in the collection
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
