package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;

import java.util.Objects;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void createUser(Context ctx) {
        var firstName = ctx.formParamAsClass("firstName", String.class).get();
        var lastName = ctx.formParamAsClass("lastName", String.class).get();
        var email = ctx.formParamAsClass("email", String.class).get();
        var password = ctx.formParamAsClass("password", String.class).get();
        var token = Security.generateToken();
        ctx.cookie("token", token);

        var user = new User(firstName, lastName, email, password, token);
        UserRepository.save(user);
        var getID = UserRepository.search(firstName).get(0);
        var id = getID.getId();
        ctx.redirect("/users/" + id);
    }
    public static void show (Context ctx) {
        var userId = ctx.pathParamAsClass("id", Long.class).get();
        var token = ctx.cookie("token");
        var user = UserRepository.find(userId)
                .orElseThrow(() -> new NotFoundResponse("User not found"));
        var page = new UserPage(user);


        if (!Objects.equals(token, user.getToken())) {
            ctx.redirect(NamedRoutes.buildUserPath());
        } else {
            ctx.render("users/show.jte", model("page", page));
        }

    }
    // END
}
