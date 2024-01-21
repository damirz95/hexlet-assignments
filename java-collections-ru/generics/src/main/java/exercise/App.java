package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
class App {
    public static List<Map<String,String>> findWhere(List<Map<String, String>> booksArr, Map<String, String> where) {
        List<Map<String, String>> result = new ArrayList<>();
        Set<String> keys = where.keySet();
        for (Map<String, String> book : booksArr) {
            for (String key: keys) {
                if (book.containsKey(key) && book.get(key).equals(where.get(key))) {
                    continue;
                } else {
                    return result;
                }
            }
            result.add(book);
        }
        return  result;
    }
}
//END
