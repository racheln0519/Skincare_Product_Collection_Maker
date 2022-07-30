package persistence;

import model.Product;
import model.ProductCollection;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


// code based on JsonReaderTest from JsonSerializationDemo

public class JsonReaderTest extends JsonTest {

    @Test
    public void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ProductCollection pc = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testReaderEmptyProductCollection() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyProductCollection.json");
        try {
            ProductCollection pc = reader.read();
            assertEquals("User's Collection", pc.getName());
            assertEquals(0, pc.collectionSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    public void testReaderGeneralProductCollection() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralProductCollection.json");
        try {
            ProductCollection pc = reader.read();
            assertEquals("User's Collection", pc.getName());
            List<Product> products = pc.getCollection();
            assertEquals(2, products.size());
            checkProduct("Cleanser", products.get(0));
            checkProduct("Toner", products.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }




}
