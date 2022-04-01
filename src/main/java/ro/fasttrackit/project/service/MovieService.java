package ro.fasttrackit.project.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.project.model.Movie;
import ro.fasttrackit.project.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public List<Movie> getAll() {
        return repository.findAll();
    }

    public Optional<Movie> getMovie(Integer id) {
        return repository.findById(id);
    }

    public Optional<Movie> delete(int id) {
        Optional<Movie> toDelete = repository.findById(id);
        toDelete.ifPresent(repository::delete);
        return toDelete;
    }

    public Movie add(Movie movie) {
        return repository.save(movie);
    }

    public Movie replace(int id, Movie movie) {
        movie.setId(id);
        return repository.save(movie);
    }
}
