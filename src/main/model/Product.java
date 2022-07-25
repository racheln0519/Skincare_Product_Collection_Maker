package model;

public class Product {
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


}
