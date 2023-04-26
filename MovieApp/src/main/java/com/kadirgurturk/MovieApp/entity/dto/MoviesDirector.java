package com.kadirgurturk.MovieApp.entity.dto;

import com.kadirgurturk.MovieApp.entity.Director;

import java.time.LocalDate;
import java.util.Set;

public class MoviesDirector {

    public String movieName;
    public LocalDate sceneDate;
    public Float cost;
    public Set<Director> directors;


    public MoviesDirector(String movieName, LocalDate sceneDate, Float cost, Set<Director> directors) {
        this.movieName = movieName;
        this.sceneDate = sceneDate;
        this.cost = cost;
        this.directors = directors;
    }
}
