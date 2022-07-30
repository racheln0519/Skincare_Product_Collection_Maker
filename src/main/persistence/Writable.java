package persistence;

import org.json.JSONObject;

// code based on Writable from JsonSerializationDemo
public interface Writable {

    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
