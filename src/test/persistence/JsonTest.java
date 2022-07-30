package persistence;

import model.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;

// code based on JsonTest from JsonSerializationDemo

public class JsonTest {
    protected void checkProduct(String name, Product product) {
        assertEquals(name, product.getName());
    }
}
