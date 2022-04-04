package ro.fasttrackit.project.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ro.fasttrackit.project.service.MovieService;

@Controller
@RequestMapping("movies")
public class MovieController {
    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    String getMoviePage(Model model, @RequestParam(required = false) Integer showMovie) {
        model.addAttribute("message", "Hello Thymeleaf");
        model.addAttribute("user", new User(1, "Ana", 22));
        model.addAttribute("movies", service.getAll());
        if (showMovie != null) {
            model.addAttribute("movieDetails", service.getMovie(showMovie)
                    .orElse(null));
        }
        return "movies";
    }

    record User(int id, String name, int age) {

    }
}
