package exercise;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App{
    public static String getForwardedVariables(String file){
        String[] stringsArr = file.split("\n");
        StringBuilder result = new StringBuilder();
        List<String[]> rs = new ArrayList<>();
        for (var s : stringsArr) {
            if (!s.isBlank() && s.startsWith("environment=")) {
                s = s.replace("environment=\"", "");
                s = s.replace('\"', ' ');
                rs.add(s.split(","));
            }
        }
        for (String[] str : rs) {
            for (String s : str) {
                if (s.startsWith("X_FORWARDED_")) {
                    result.append(" ");
                    result.append(s);
                }
            }
        }
        List<String> value = List.of(result.toString().split(" "));
        value = value.stream()
                .filter(s -> s.startsWith("X_FORWARDED_"))
                .map(s -> s.replace("X_FORWARDED_", ""))
                .toList();
        StringBuilder v = new StringBuilder();
        for (var s : value) {
            v.append(",");
            v.append(s);
        }
        return v.toString().substring(1, v.length());
    }
}
//END
