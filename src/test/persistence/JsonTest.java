package persistence;

import model.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkProduct(String name, Product product) {
        assertEquals(name, product.getName());
    }
}
