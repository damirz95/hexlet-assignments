package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> people) {
        List<String> result = new ArrayList<>();

        return people.stream()
                .filter(p -> p.get("gender").equals("male"))
                .sorted((p1, p2) -> LocalDate.parse(p1.get("birthday")).compareTo( LocalDate.parse(p2.get("birthday"))))
                .map(p -> p.get("name"))
                .collect(Collectors.toList());
    }
}
// END
