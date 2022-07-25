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
        cleanser = new Product("Fresh: Soy Face Cleanser");
        toner = new Product ("Laneige: Cream Skin Toner");
        serum = new Product ("Sulwhasoo: Activating Serum");
        moisturizer = new Product("First Aid Beauty: Ultra Repair Cream");
        sunscreen = new Product("Biore: Aqua Rich Sunscreen");
    }

    @Test
    public void testProduct() {
        assertEquals("Fresh: Soy Face Cleanser", cleanser.getName());
        assertEquals("Laneige: Cream Skin Toner", toner.getName());
        assertEquals("Sulwhasoo: Activating Serum", serum.getName());
    }

    @Test
    public void testGetNames() {
        assertEquals("Fresh: Soy Face Cleanser", cleanser.getName());
        assertEquals("Laneige: Cream Skin Toner", toner.getName());
        assertEquals("Sulwhasoo: Activating Serum", serum.getName());
        assertEquals("First Aid Beauty: Ultra Repair Cream", moisturizer.getName());
        assertEquals("Biore: Aqua Rich Sunscreen", sunscreen.getName());
    }



}