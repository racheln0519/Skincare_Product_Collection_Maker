package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    private Product cleanser;
    private Product toner;
    private Product serum;
    private Product moisturizer;
    private Product sunscreen;

    @BeforeEach
    public void runBefore() {
        cleanser = new Product("Fresh: Soy Face Cleanser", "Cleanser", "Hydrating");
        toner = new Product ("Laneige: Cream Skin Toner", "Toner", "Hypoallergenic");
        serum = new Product ("Sulwhasoo: Activating Serum", "Serum", "Anti-Aging");
        moisturizer = new Product("FAB: Ultra Repair Cream", "Moisturizer", "Hydrating");
        sunscreen = new Product("Biore: Aqua Rich Sunscreen", "Sunscreen", "SPF 50");
    }

    @Test
    public void testGetTypes() {
        assertEquals("Cleanser", cleanser.getType());
        assertEquals("Toner", toner.getType());
        assertEquals("Serum", serum.getType());
        assertEquals("Moisturizer", moisturizer.getType());
        assertEquals("Sunscreen", sunscreen.getType());
    }

    @Test
    public void getNames() {
        assertEquals("Fresh: Soy Face Cleanser", cleanser.getName());
        assertEquals("Laneige: Cream Skin Toner", toner.getName());
        assertEquals("Sulwhasoo: Activating Serum", serum.getName());
        assertEquals("FAB: Ultra Repair Cream", moisturizer.getName());
        assertEquals("Biore: Aqua Rich Sunscreen", sunscreen.getName());
    }

    @Test
    public void getDescriptions() {
        assertEquals("Hydrating", cleanser.getDescription());
        assertEquals("Hypoallergenic", toner.getDescription());
        assertEquals("Anti-Aging", serum.getDescription());
        assertEquals("Hydrating", moisturizer.getDescription());
        assertEquals("SPF 50", sunscreen.getDescription());
    }


}