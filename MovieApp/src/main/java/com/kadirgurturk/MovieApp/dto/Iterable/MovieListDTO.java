package com.kadirgurturk.MovieApp.dto.Iterable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kadirgurturk.MovieApp.entity.dto.MovieList;

import java.util.List;

public class MovieListDTO {
    @JsonProperty("directors_movies")
    public List<MovieList> movieListDto;
}
