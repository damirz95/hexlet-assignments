package exercise;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String wordOne, String wordTwo) {
        if (wordOne.length() == 0 || wordTwo.length() == 0) {
            return false;
        }
        List<String> wordOneList = Arrays.asList(wordOne.toLowerCase().split(""));
        List<String> wordTwoList = Arrays.asList(wordTwo.toLowerCase().split(""));
        List<String> result = new ArrayList<>();
        result.removeAll(wordOneList);
        result.removeAll(wordTwoList);
        for (String wordChar : result) {
            if (wordTwoList.contains(wordChar)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
//END
