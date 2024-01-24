package exercise;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
class App{
    public static String getForwardedVariables(String file) {
        String[] stringsArr = file.split("\n");
        return Arrays.stream(stringsArr)
                .filter(line -> line.startsWith("environment="))
                .map(line -> line.replace("environment=", ""))
                .map(line -> line.replace("\"", ""))
                .map(line -> line.split(","))
                .flatMap(Arrays::stream)
                .filter(s -> s.startsWith("X_FORWARDED_"))
                .map(s -> s.replace("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
