package ui;

import model.ProductCollection;

import java.io.FileNotFoundException;

public class MakeChangesToProductCollection {

//    private static ProductCollection productCollection;
//
//
//    public static ProductCollection main(String[] args) {
////        MakeChangesToProductCollection changesToCollection = new MakeChangesToProductCollection();
//
//        public void ProductCollection() {
//            productCollection = new ProductCollection("User's Collection");
//        }
//
//        // getters
//        public ProductCollection getProductCollection() {
//            return productCollection;
//        }
//
//        try {
//            InputProduct inputProduct = new InputProduct(getProductCollection);
//            inputProduct.handleInput();
//            inputProduct.endProgram();
//
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to run application: file not found");
//        }
//
//    }
//}

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