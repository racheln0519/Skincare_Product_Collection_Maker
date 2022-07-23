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
    private Collection testCollection;

    @BeforeEach
    public void runBefore() {
        testCollection = new Collection("User's Collection");

        cleanser = new Product("Fresh: Soy Face Cleanser", ProductType.CLEANSER, "Hydrating");
        cleanser.setHomeCollection(testCollection);
        toner = new Product("Laneige: Cream Skin Toner", ProductType.TONER, "Hypoallergenic");
        toner.setHomeCollection(testCollection);
        serum = new Product("Sulwhasoo: Activating Serum", ProductType.SERUM, "Anti-Aging");
        serum.setHomeCollection(testCollection);
        moisturizer = new Product("FAB: Ultra Repair Cream", ProductType.MOISTURIZER, "Hydrating");
        moisturizer.setHomeCollection(testCollection);
        sunscreen = new Product("Biore: Aqua Rich Sunscreen", ProductType.SUNSCREEN, "SPF 50");
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


