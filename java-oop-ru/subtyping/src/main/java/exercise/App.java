package exercise;

import java.util.Map;

// BEGIN
public class App {
    public static KeyValueStorage swapKeyValue(KeyValueStorage dataSet) {
        Map<String, String> map = dataSet.toMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            dataSet.set(entry.getValue(), entry.getKey());
            dataSet.unset(entry.getKey());
        }
        return dataSet;
    }
}
// END
