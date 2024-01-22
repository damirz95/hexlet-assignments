package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> whear = new ArrayList<>(List.of(1, 2));
        List<Integer> actual = App.take(numbers1, 2);
        assertThat(actual).isEqualTo(whear);
        // END
    }
    @Test
    void testTake2() {
        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(7, 3, 10));
        List<Integer> whear = new ArrayList<>(List.of(7, 3, 10));
        List<Integer> actual = App.take(numbers2, 3);
        assertThat(actual).isEqualTo(whear);
    }
}
