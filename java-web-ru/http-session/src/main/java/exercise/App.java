package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var pageNumber = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
            var perNumber = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);
            List<Map<String, String>> result = new ArrayList<>();
            if (perNumber == 5 && pageNumber == 1) {
                for (int i = 0; i < perNumber; i++){
                    result.add(USERS.get(i));
                }
                ctx.json(result);
            } else {
                int index = (perNumber * pageNumber) - perNumber;
                for (int i = index; i < perNumber * pageNumber; i++) {
                    result.add(USERS.get(i));
                }
                ctx.json(result);
            }

        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
