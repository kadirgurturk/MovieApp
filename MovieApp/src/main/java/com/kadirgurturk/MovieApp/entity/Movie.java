package com.kadirgurturk.MovieApp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

/// name varchar(256) not null,
//    scene_date date not null,
//    rating bigint not null default(0) check(rating >= 0),
//    cost real not null,
//    imdb float4 not null default(0.0)
//);

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "movie_id", length = 256)
    long movieId;

    @Column(name = "name")
    String movieName;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @Column(name = "scene_date")
    LocalDate sceneDate;

    @Column(name = "rating", nullable = false)
    private Long rating;

    @Column(name = "cost", nullable = false)
    private Float cost;

    @Column(name = "imdb", nullable = false)
    private Float imdb;

    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    private Set<Director> directors;

    public Movie() {
    }

    public Set<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public LocalDate getSceneDate() {
        return sceneDate;
    }

    public void setSceneDate(LocalDate sceneDate) {
        this.sceneDate = sceneDate;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Float getImdb() {
        return imdb;
    }

    public void setImdb(Float imdb) {
        this.imdb = imdb;
    }
}
