package persistence;

import model.Product;
import model.ProductCollection;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// code based on JsonWriterTest from JsonSerializationDemo

public class JsonWriterTest extends JsonTest {

    @Test
    public void testWriterInvalidFile() {
        try {
            ProductCollection pc = new ProductCollection("User's Collection");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {

        }
    }

    @Test
    public void testWriterEmptyProductCollection() {
        try {
            ProductCollection pc = new ProductCollection("User's Collection");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyProductCollection.json.json");
            writer.open();
            writer.write(pc);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyProductCollection.json.json");
            pc = reader.read();
            assertEquals("User's Collection", pc.getName());
            assertEquals(0, pc.collectionSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    public void testWriterGeneralProductCollection() {
        try {
            ProductCollection pc = new ProductCollection("User's Collection");
            pc.addProduct(new Product("Cleanser"));
            pc.addProduct(new Product("Toner"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralProductCollection.json.json");
            writer.open();
            writer.write(pc);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralProductCollection.json.json");
            pc = reader.read();
            assertEquals("User's Collection", pc.getName());
            List<Product> collection = pc.getCollection();
            assertEquals(2, collection.size());
            checkProduct("Cleanser", collection.get(0));
            checkProduct("Toner", collection.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }





}

