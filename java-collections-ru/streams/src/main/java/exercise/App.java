package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static Long getCountOfFreeEmails(List<String> emails) {
        List<String> freeEmail = List.of("gmail.com", "yandex.ru", "hotmail.com");
        return emails.stream()
                .map(email -> email.split("@")[1])
                .filter(freeEmail::contains)
                .count();
    }
}
// END
