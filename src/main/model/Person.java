package model;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private List<Product> collection;

    public Person(String name) {
        this.name = name;
        collection = new ArrayList<>();
    }

    // getters
    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return collection;
    }

    public void setName(String name) {
        this.name = name;
    }



}
