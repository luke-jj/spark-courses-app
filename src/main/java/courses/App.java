package courses;

import java.util.Map;
import java.util.HashMap;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        // get is a static method on the 'Spark' class that handles GET requests
        get("/hello", (req, res) -> "Hello World");

        get("/", (req, res) -> {
            Map<String,String> model = new HashMap<>();
            model.put("username", req.cookie("username"));

            // ModelAndView(Model, View)
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/sign-in", (req, res) -> {
            Map<String,String> model = new HashMap<>();

            // extract transmitted data from the post request
            String username = req.queryParams("username");

            model.put("username", username);

            // set a cookie that is send with the response
            res.cookie("username", username);

            return new ModelAndView(model, "sign-in.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
