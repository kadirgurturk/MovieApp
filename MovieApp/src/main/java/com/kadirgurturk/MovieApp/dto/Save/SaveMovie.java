package com.kadirgurturk.MovieApp.dto.Save;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;

import java.time.LocalDate;

public class SaveMovie {

    @NotNull(message = "movie name can not be null")
    public String movieName;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @NotNull(message = "scene date can not be null")
    public LocalDate sceneDate;

    @NotNull(message = "movie rating can not be null")
    @Max(value = 10,message = "movie rating can not be higher than 10")
    @Min(value = 0, message = "movie rating can not be lower than 0")
    public Long rating;

    @NotNull(message = "cost price can not be null")
    public Float cost;

    @Max(value = 10,message = "imdb score can not be higher than 10.0")
    @Min(value = 0, message = "imdb score can not be lower than 0.0")
    @NotNull(message = "imdb score can not be null")
    public Float imdb;

    public SaveMovie(String movieName, LocalDate sceneDate, Long rating, Float cost, Float imdb) {
        this.movieName = movieName;
        this.sceneDate = sceneDate;
        this.rating = rating;
        this.cost = cost;
        this.imdb = imdb;
    }

    public SaveMovie() {

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
