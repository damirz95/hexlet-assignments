package exercise.dto.users;

import exercise.model.User;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

// BEGIN
@AllArgsConstructor
@Getter
@ToString
public final class UsersPage {
    private List<User> users;
    private String header;

}
// END
