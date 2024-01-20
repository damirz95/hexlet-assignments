package exercise;

import java.util.Arrays;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(List<String> words) {
        String[] word = words.get(0).toLowerCase().split("");
        String[] word2 = words.get(1).toLowerCase().split("");
        int count = Math.min(words.get(0).length(), words.get(1).length());
        List<String> wordList = Arrays.asList(word);
        List<String> wordList2 = Arrays.asList(word2);
        for (int i = 0; i < count + 1; i++) {
            if (wordList2.contains(wordList.get(i))) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
//END
