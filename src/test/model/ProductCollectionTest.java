package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductCollectionTest {

    private Product cleanser;
    private Product toner;
    private Product serum;
    private Product moisturizer;
    private Product sunscreen;
    private ProductCollection testCollection;

    @BeforeEach
    public void runBefore() {
        testCollection = new ProductCollection("User's Collection");

        cleanser = new Product("Fresh: Soy Face Cleanser");
        toner = new Product("Laneige: Cream Skin Toner");
        serum = new Product("Sulwhasoo: Activating Serum");
        moisturizer = new Product("First Aid Beauty: Ultra Repair Cream");
        sunscreen = new Product("Biore: Aqua Rich Sunscreen");
    }

    @Test
    public void testGetName() {
        assertEquals("User's Collection", testCollection.getName());
    }

    @Test
    public void testAddProduct() {
        testCollection.addProduct(cleanser);
        testCollection.addProduct(toner);
        assertTrue(testCollection.inCollection(cleanser));
    }

    @Test
    public void testRemoveProduct() {
        testCollection.addProduct(serum);
        testCollection.addProduct(moisturizer);
        testCollection.addProduct(sunscreen);
        testCollection.removeProduct(sunscreen);
        assertFalse(testCollection.inCollection(sunscreen));
    }




}


