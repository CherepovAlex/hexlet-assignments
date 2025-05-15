package exercise;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import io.javalin.http.NotFoundResponse;
import static io.javalin.rendering.template.TemplateUtil.model;

import gg.jte.TemplateEngine;
import gg.jte.resolve.DirectoryCodeResolver;
import gg.jte.ContentType;

import java.nio.file.Paths;
import java.util.List;

import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;


public final class App {

    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var templateEngine = TemplateEngine.create(
                new DirectoryCodeResolver(Paths.get("src/main/jte")),
                ContentType.Html
        );

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte(templateEngine));
        });

        app.get("/users/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).get();

            User user = USERS.stream()
                .filter(u -> id.equals(u.getId()))
                .findFirst()
                .orElseThrow(() -> new NotFoundResponse("User not found"));

            var page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        });

        app.get("/users", ctx -> {
            var page = new UsersPage(USERS);
            ctx.render("users/index.jte", model("page", page));

        });

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
