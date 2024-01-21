package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String words) {
        Map<String, Integer> result = new HashMap<>();
        if (words.isEmpty()) {
            return result;
        }
        String[] wordsArray = words.trim().toLowerCase().split(" ");
        for (String word: wordsArray) {
            int count = result.getOrDefault(word, 0);
            result.put(word, count + 1);
        }
        return result;
    }
    public static String toString(Map<String, Integer> wordsCount) {
        if (wordsCount.isEmpty()) {
            return "{}";
        }
        var entries = wordsCount.entrySet();
        StringBuilder result = new StringBuilder("{\n");
        for (var entry: entries) {
            result.append("  ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        result.append("}");
        return result.toString();
    }
}
//END
