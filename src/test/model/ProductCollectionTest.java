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
    public void testProductCollection() {
        assertEquals("User's Collection", testCollection.getName());
        assertTrue(testCollection.isEmpty());
    }

    @Test
    public void testAddProduct() {
        assertEquals(0, testCollection.collectionSize());
        testCollection.addProduct(cleanser);
        testCollection.addProduct(toner);
        assertEquals(2, testCollection.collectionSize());
    }

    @Test
    public void testRemoveProduct() {
        testCollection.addProduct(serum);
        testCollection.addProduct(moisturizer);
        testCollection.addProduct(sunscreen);
        assertEquals(3, testCollection.collectionSize());
        testCollection.removeProduct(sunscreen);
        assertEquals(2, testCollection.collectionSize());
    }

    @Test
    public void testGetCollectionEmpty() {
        assertEquals(0, testCollection.collectionSize());
    }

    @Test
    public void testGetCollection() {
        testCollection.addProduct(cleanser);
        testCollection.addProduct(serum);
        testCollection.getCollection();
        assertEquals(2, testCollection.collectionSize());
    }

    @Test
    public void testInCollectionNotIn() {
        testCollection.addProduct(serum);
        testCollection.addProduct(toner);
        testCollection.getCollection();
        assertFalse(testCollection.inCollection(sunscreen));
    }

    @Test
    public void testInCollection() {
        testCollection.addProduct(cleanser);
        testCollection.addProduct(toner);
        testCollection.addProduct(moisturizer);
        assertTrue(testCollection.inCollection(cleanser));
    }

    @Test
    public void testIsEmptyNotEmpty() {
        testCollection.addProduct(sunscreen);
        assertFalse(testCollection.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(testCollection.isEmpty());
    }

    @Test
    public void testCollectionSize() {
        testCollection.addProduct(cleanser);
        testCollection.addProduct(moisturizer);
        testCollection.addProduct(sunscreen);
        assertEquals(3, testCollection.collectionSize());
    }


}


