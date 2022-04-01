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
	CommandLineRunner atStartup(MovieRepository repo){
		return args -> {
			repo.saveAll(List.of(
					new Movie("The Wolf", 25),
					new Movie("Spiderman", 71),
					new Movie("Batman", 33),
					new Movie("Morbius", 150),
					new Movie("The lost city", 17)));
			System.out.println(repo.byIdAndNameCustom(2,"%are%"));
			System.out.println(repo.byTypeCustom(ACTION));
		};
	}
}
