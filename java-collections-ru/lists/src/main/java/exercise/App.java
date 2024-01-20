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
        String[] wd1 = wordOne.toLowerCase().split("");
        String[] wd2 = wordTwo.toLowerCase().split("");
        List<String> wordOneList = new ArrayList<>();
        for (var ch: wd1) {
            wordOneList.add(ch);
        }
        List<String> wordTwoList = new ArrayList<>();
        for (var ch: wd2) {
            wordTwoList.add(ch);
        }
        for (var e : wordTwoList) {
            if (wordOneList.contains(e)) {
                wordOneList.remove(e);
            } else {
                return false;
            }
        }

        return true;
    }
}
//END
