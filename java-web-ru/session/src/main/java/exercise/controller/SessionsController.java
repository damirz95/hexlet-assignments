package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;

import java.util.Objects;

public class SessionsController {

    // BEGIN
    public static void session(Context ctx) {
        var page = new MainPage(ctx.sessionAttribute("name"));
        ctx.render("index.jte", model("page", page));
    }
    public static  void createPage(Context ctx) {
        var page = new LoginPage(null, null);
        ctx.render("build.jte", model("page", page));
    }
    public static void create(Context ctx) {

        var name = ctx.formParam("name");
        var password = ctx.formParam("password");
        String error = "Wrong username or password";
        var page = new LoginPage(name, error);
        if (UsersRepository.existsByName(name)) {
            var user = UsersRepository.findByName(name);
            if (Objects.equals(user.getPassword(), encrypt(password))) {
                ctx.sessionAttribute("name", name);
                ctx.redirect(NamedRoutes.rootPath());
            } else {

                ctx.render("build.jte", model("page", page));
            }
        }else {

            ctx.render("build.jte", model("page", page));
        }
    }
    public static void destroy(Context ctx) {
        ctx.sessionAttribute("name", null);
        ctx.redirect("/");
    }
    // END
}
