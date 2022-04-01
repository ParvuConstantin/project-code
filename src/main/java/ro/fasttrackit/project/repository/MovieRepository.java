package ro.fasttrackit.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.fasttrackit.project.model.Movie;
import ro.fasttrackit.project.model.MovieType;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findAllByNameLike(String pattern);

    @Query("select tran from Movie tran where tran.type=:type")
    List<Movie> byTypeCustom(@Param("type") MovieType type);

    @Query(value = "select * from movie m where m.id=:id and m.name like :pattern", nativeQuery = true)
    Movie byIdAndNameCustom(@Param("id") int id, @Param("pattern") String pattern);
}
