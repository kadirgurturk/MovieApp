package com.kadirgurturk.MovieApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class MovieDto {

    public String movieName;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    public LocalDate sceneDate;


    public Long rating;


    public Float cost;


    public Float imdb;

    public MovieDto() {

    }
}
