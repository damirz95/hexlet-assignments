package exercise;

import io.javalin.Javalin;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get("/users", ctx -> {
            var users = USERS;
            var header = "Список пользователей";
            var usersP = new UsersPage(users, header);
            ctx.render("users/index.jte", model("usersP", usersP));
        });
        app.get("/users/{id}", ctx -> {
            var userId = ctx.pathParam("id");
            var header = "Пользователь";
            List<String> usersId = new ArrayList<>();
            for (var user: USERS) {
                var us1 = String.valueOf(user.getId());
                usersId.add(us1);

                if(us1.equals(userId)) {
                    var userP = new UserPage(user, header);
                    ctx.render("users/show.jte", model("userP", userP));
                }
            }
            if (!usersId.contains(userId)) {
                throw new NotFoundResponse("User not found");
            }
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
