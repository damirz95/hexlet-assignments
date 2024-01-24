package exercise;

import java.beans.PropertyEditorSupport;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
class App{
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        TreeSet<String> treeDataSetKeys = new TreeSet<>(data1.keySet());
        treeDataSetKeys.addAll(data2.keySet());

        for (String key : treeDataSetKeys) {
            boolean key1 = data1.containsKey(key);
            boolean key2 = data2.containsKey(key);
            Object value1 = data1.get(key);
            Object value2 = data2.get(key);
            if (key1 == key2 && value1.equals(value2)) {
                result.put(key, "unchanged");
            }else if (key1 == key2 && !value1.equals(value2)) {
                result.put(key, "changed");
            }else if (data1.containsKey(key) && !data2.containsKey(key)) {
                result.put(key, "deleted");
            }else if (data2.containsKey(key) && !data1.containsKey(key)) {
                result.put(key, "added");
            }
        }



        return result;
    }
}
//END
