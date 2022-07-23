package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CollectionTest {

    private Product cleanser;
    private Product toner;
    private Product serum;
    private Product moisturizer;
    private Product sunscreen;
    private ProductCollection testCollection;

    @BeforeEach
    public void runBefore() {
        testCollection = new ProductCollection("User's Collection");

        cleanser = new Product("Fresh: Soy Face Cleanser", "Cleanser", "Hydrating");
        cleanser.setHomeCollection(testCollection);
        toner = new Product("Laneige: Cream Skin Toner", "Toner", "Hypoallergenic");
        toner.setHomeCollection(testCollection);
        serum = new Product("Sulwhasoo: Activating Serum", "Serum", "Anti-Aging");
        serum.setHomeCollection(testCollection);
        moisturizer = new Product("FAB: Ultra Repair Cream", "Moisturizer", "Hydrating");
        moisturizer.setHomeCollection(testCollection);
        sunscreen = new Product("Biore: Aqua Rich Sunscreen", "Sunscreen", "SPF 50");
    }

    @Test
    public void testGetName() {
        assertEquals("User's Collection", testCollection.getName());
    }

    @Test
    public void testInCollection() {
        assertTrue(testCollection.inCollection(cleanser));
        assertTrue(testCollection.inCollection(toner));
        assertTrue(testCollection.inCollection(serum));
        assertTrue(testCollection.inCollection(moisturizer));
        assertFalse(testCollection.inCollection(sunscreen));
    }



}


