package exercise;

import java.util.*;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List<Map<String,String>> findWhere(List<Map<String,String>> books, Map<String,String> filter) {
        List<Map<String, String>> result = new ArrayList<>();
        Collection<String> filterColet = filter.values();
        for (var book : books) {
            if (book.values().containsAll(filterColet)) {
                result.add(book);
            }
        }
        return result;
    }
}
//END
