package model;

import org.json.JSONObject;
import persistence.Writable;

// Product class represents a product with a given name
public class Product implements Writable {
    private String name;
    private ProductCollection homeRoutine;

    // EFFECTS: constructs a skincare product with given name
    public Product(String name) {
        this.name = name;
    }

    // getters
    public String getName() {
        return name;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        return json;
    }

}
