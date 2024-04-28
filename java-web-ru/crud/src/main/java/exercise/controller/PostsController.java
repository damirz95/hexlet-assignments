package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import java.util.List;
import java.util.ArrayList;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void posts(Context ctx) {
        var pageNumber = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var per = 5;
        int offset = (pageNumber - 1) * per;
        var page = new PostsPage(PostRepository.getEntities().subList(offset, offset + per), pageNumber);
        ctx.render("posts/index.jte", model("page", page));
    }
    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        Post post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Page not found"));
        PostPage page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }
    // END
}
