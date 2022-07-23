package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Collection {
    private String name;
    private List<Product> collection;
//    private List<Product> cleansers;
//    private List<Product> toners;
//    private List<Product> serums;
//    private List<Product> moisturizers;
//    private List<Product> sunscreens;

    // EFFECTS: constructs an empty collection with the type categories being empty
    public Collection(String name) {
        this.name = name;
        collection = new ArrayList<Product>();
//        cleansers = new LinkedList<>();
//        toners = new LinkedList<>();
//        serums = new LinkedList<>();
//        moisturizers = new LinkedList<>();
//        sunscreens = new LinkedList<>();
    }

    // getters
    public String getName() {
        return name;
    }

//    public List<Product> getCleansers() {
//        return cleansers;
//    }
//
//    public List<Product> getToners() {
//        return toners;
//    }
//
//    public List<Product> getSerums() {
//        return serums;
//    }
//
//    public List<Product> getMoisturizers() {
//        return moisturizers;
//    }
//
//    public List<Product> getSunscreens() {
//        return sunscreens;
//    }

    // MODIFIES: this
    // EFFECTS: adds and sorts product into a skincare category
    public void sortProduct(Product product) {
        collection.add(product);
//        ProductType type = product.getType();
//
//        if (!collection.contains(product)) {
//            switch (type) {
//                case CLEANSER:
//                    this.cleansers.add(product);
//                    break;
//                case TONER:
//                    this.toners.add(product);
//                    break;
//                case SERUM:
//                    this.serums.add(product);
//                    break;
//                case SUNSCREEN:
//                    this.sunscreens.add(product);
//                    break;
//                case MOISTURIZER:
//                    this.moisturizers.add(product);
//                    break;
//            }
//        }
//        System.out.println("This product has already been sorted.");
    }


    // MODIFIES: this
    // EFFECTS: removes a product from a skincare category
    public void removeProduct(Product product) {
        collection.remove(product);
//        ProductType type = product.getType();
//
//        if (collection.contains(product)) {
//            switch (type) {
//                case CLEANSER:
//                    this.cleansers.remove(product);
//                    break;
//                case TONER:
//                    this.toners.remove(product);
//                    break;
//                case SERUM:
//                    this.serums.remove(product);
//                    break;
//                case SUNSCREEN:
//                    this.sunscreens.remove(product);
//                    break;
//                case MOISTURIZER:
//                    this.moisturizers.remove(product);
//                    break;
//            }
//        }
//        System.out.println("Given product is not in the collection");
    }


    // EFFECTS: checks to see if the given product is contained in the lists of products
    public boolean inCollection(Product product) {
        return collection.contains(product);
//        Product product = product.getType();

//        switch (type) {
//            case CLEANSER:
//                return cleansers.contains(product);
//            case TONER:
//                return toners.contains(product);
//            case SERUM:
//                return serums.contains(product);
//            case SUNSCREEN:
//                return sunscreens.contains(product);
//            case MOISTURIZER:
//                return moisturizers.contains(product);
//            default:
//                return false;
//        }
    }

//    // EFFECTS: returns number of cleansers
//    public int getNumberOfCleansers() {
//        return cleansers.size();
//    }
//
//    // EFFECTS: returns number of toners
//    public int getNumberOfToners() {
//        return toners.size();
//    }
//
//    // EFFECTS: returns number of serums
//    public int getNumberOfSerums() {
//        return serums.size();
//    }
//
//    // EFFECTS: returns number of moisturizers
//    public int getNumberOfMoisturizers() {
//        return moisturizers.size();
//    }
//
//    // EFFECTS: returns number of sunscreens
//    public int getNumberOfSunscreens() {
//        return sunscreens.size();
//    }

}
