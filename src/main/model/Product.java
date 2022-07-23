package model;

public class Product {
    private String name;
    private String type;
    private String description;
    private Collection homeRoutine;

    // EFFECTS: constructs a skincare product with name, description, and price
    public Product(String name, String type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }

    // EFFECTS: returns product name
    public String getName() {
        return name;
    }

    // EFFECTS: returns product type
    public String getType() {
        return type;
    }

    // EFFECTS: returns product description
    public String getDescription() {
        return description;
    }

    // TODO: effects clause
    // REQUIRES: collection != null
    // MODIFIES: this
    // EFFECTS: sets the product's home __ to the one passed as parameter
    public void setHomeCollection(Collection collection) {
        homeRoutine = collection;
        collection.sortProduct(this);
    }

}
