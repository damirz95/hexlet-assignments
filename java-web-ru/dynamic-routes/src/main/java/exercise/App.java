package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

// BEGIN
import io.javalin.http.NotFoundResponse;
// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("companies/{id}", ctx -> {
            var comID = ctx.pathParam("id");
            var allID = new ArrayList<>();
            for (int i = 0; i < COMPANIES.size(); i++) {
                allID.add(COMPANIES.get(i).get("id"));
                if (COMPANIES.get(i).get("id").equals(comID)) {
                    ctx.json(COMPANIES.get(i));
                }
            }
            if (!allID.contains(comID)) {
                throw new NotFoundResponse("Company not found");
            }
        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
