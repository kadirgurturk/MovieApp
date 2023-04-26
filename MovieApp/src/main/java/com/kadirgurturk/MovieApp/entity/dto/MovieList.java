package com.kadirgurturk.MovieApp.entity.dto;

//"name": "Face Off",
//            "sceneDate":"1996-05-12"
//            "cost": "1000000.67"


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class MovieList {

    public String movieName;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    public LocalDate sceneDate;
    public Float cost;

    public MovieList(String movieName, LocalDate sceneDate, Float cost) {
        this.movieName = movieName;
        this.sceneDate = sceneDate;
        this.cost = cost;
    }
}
