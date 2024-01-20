package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(List<String> words) {
        String[] word = words.get(0).toLowerCase().split("");
        String[] word2 = words.get(1).toLowerCase().split("");
        int count = Math.max(words.get(0).length(), words.get(1).length());
        for (int i = 0; i < count; i++) {
            if (word[i].equals(word2[i])) {
                continue;
            } else {return false;}
        }
        return true;
    }
}
//END
