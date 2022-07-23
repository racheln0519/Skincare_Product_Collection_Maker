package ui;

import model.Product;
import model.ProductCollection;

public class MakeChangesToProductCollection {

    private ProductCollection productCollection;

    public static void main(String[] args) {
        MakeChangesToProductCollection changesToCollection = new MakeChangesToProductCollection();
        InputProduct inputProduct = new InputProduct(changesToCollection.getProductCollection());
        System.out.println("Welcome! Let's make changes to your skincare collection!");

        inputProduct.handleInput();
        inputProduct.endProgram();

        System.out.println("See you later!");
    }

    public MakeChangesToProductCollection() {
        productCollection = new ProductCollection("User's Collection");
    }

    // getters
    public ProductCollection getProductCollection() {
        return productCollection;
    }





}
