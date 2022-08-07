package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// ProductCollection class represents a collection with a given name that stores all the products created.
// A money saving method is implemented and prevents users from adding products
public class ProductCollection implements Writable {
    private String name;
    private List<Product> collection;
    private boolean isSavingMoney;


    // EFFECTS: constructs an empty collection with given name
    public ProductCollection(String name) {
        this.name = name;
        collection = new ArrayList<>();
        isSavingMoney = false;
    }

    // getters
    public String getName() {
        return name;
    }

    public List<Product> getCollection() {
        return collection;
    }

    public boolean savemoney() {
        return isSavingMoney;
    }

    // MODIFIES: this
    // EFFECTS: sets a field in this collection such that the user is saving money
    public void savingMoney() {
        isSavingMoney = true;
    }

    // MODIFIES: this
    // EFFECTS: sets a field in this collection such that the user is not saving money
    public void notSavingMoney() {
        isSavingMoney = false;
    }

    // MODIFIES: this
    // EFFECTS: adds a skincare product to collection if product is not contained in the collection and if user is not
    // saving money; false otherwise
    public boolean addProduct(Product product) {
        if (!isSavingMoney) {
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

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("collection", collectionToJson());
        return json;
    }

    // EFFECTS: returns products in collection as a JSON array
    private JSONArray collectionToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Product product : collection) {
            jsonArray.put(product.toJson());
        }
        return jsonArray;
    }
}
