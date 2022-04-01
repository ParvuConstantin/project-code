package ro.fasttrackit.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Movie {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private MovieType type;
    private double rezervation;

    protected Movie() {
    }

    public Movie(String name, double rezervation) {
        this(name, MovieType.ACTION, rezervation);
    }

    public Movie(String name, MovieType type, double rezervation) {
        this.name = name;
        this.rezervation = rezervation;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRezervation() {
        return rezervation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MovieType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", rezervation=" + rezervation +
                '}';
    }
}
