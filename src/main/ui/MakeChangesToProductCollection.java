package ui;

import model.ProductCollection;

public class MakeChangesToProductCollection {

    private ProductCollection productCollection;

    public static void main(String[] args) {
        MakeChangesToProductCollection changesToCollection = new MakeChangesToProductCollection();

        InputProduct inputProduct = new InputProduct(changesToCollection.getProductCollection());

        inputProduct.handleInput();
        inputProduct.endProgram();
    }

    public MakeChangesToProductCollection() {
        productCollection = new ProductCollection("User's Collection");
    }

    // getters
    public ProductCollection getProductCollection() {
        return productCollection;
    }
}