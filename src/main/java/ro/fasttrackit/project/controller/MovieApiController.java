package ro.fasttrackit.project.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.project.model.Movie;
import ro.fasttrackit.project.service.MovieService;

@RestController
@RequestMapping("api/movies")
public class MovieApiController {
    private final MovieService service;

    public MovieApiController(MovieService service) {
        this.service = service;
    }

    @PostMapping
    Movie addMovie(@RequestBody Movie movie) {
        return service.add(movie);
    }

    @PutMapping("{id}")
    Movie replaceMovie(@PathVariable int id, @RequestBody Movie movie) {
        return service.replace(id, movie);
    }

    @DeleteMapping("{id}")
    Movie deleteMovie(@PathVariable int id) {
        return service.delete(id)
                .orElse(null);
    }
}
