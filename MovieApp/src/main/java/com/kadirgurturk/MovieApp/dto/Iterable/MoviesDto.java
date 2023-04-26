package com.kadirgurturk.MovieApp.dto.Iterable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kadirgurturk.MovieApp.dto.MovieDto;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.List;

public class MoviesDto {

    @JsonProperty("movies")
    public List<MovieDto> moviesDto;

}
