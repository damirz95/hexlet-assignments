package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private Map<String, String> dataSet;

    public InMemoryKV(Map<String, String> data) {
        this.dataSet = new HashMap(data);
    }
    public void set(String key, String value) {
        dataSet.put(key, value);
    }

    public void unset(String key) {
        dataSet.remove(key);
    }

    public String get(String key, String defaultValue) {
       return dataSet.getOrDefault(key, defaultValue);
    }

    public Map<String, String> toMap() {
        return new HashMap<>(dataSet);
    }
}
// END
