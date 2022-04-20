package ro.fasttrackit.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.project.model.Movie;
import ro.fasttrackit.project.repository.MovieRepository;

import java.util.List;

import static ro.fasttrackit.project.model.MovieType.ACTION;

@SpringBootApplication
public class ProjectCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectCodeApplication.class, args);
    }

    @Bean
    CommandLineRunner atStartup(MovieRepository repo) {
        return args -> {
            repo.saveAll(List.of(
                    new Movie("Venom", 75),
                    new Movie("Wanted", 35),
                    new Movie("Jaf cu stil", 51),
                    new Movie("Dictatorul", 29),
                    new Movie("Batman", 33),
                    new Movie("Morbius", 68),
                    new Movie("The lost city", 29)));
            System.out.println(repo.byIdAndNameCustom(2, "%are%"));
            System.out.println(repo.byTypeCustom(ACTION));
        };
    }
}
