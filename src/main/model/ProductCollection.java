package model;

import java.util.ArrayList;
import java.util.List;

public class ProductCollection {
    private String name;
    private List<Product> collection;


    // EFFECTS: constructs an empty collection with the type categories being empty
    public ProductCollection(String name) {
        this.name = name;
        collection = new ArrayList<>();
    }

    // getters
    public String getName() {
        return name;
    }

    // MODIFIES: this
    // EFFECTS: adds and sorts product into a skincare category
    public void addProduct(Product product) {
        collection.add(product);
    }


    // MODIFIES: this
    // EFFECTS: removes a product from a skincare category
    public void removeProduct(Product product) {
        collection.remove(product);
    }


    // EFFECTS: checks to see if the given product is contained in the lists of products
    public boolean inCollection(Product product) {
        return collection.contains(product);
    }
}
