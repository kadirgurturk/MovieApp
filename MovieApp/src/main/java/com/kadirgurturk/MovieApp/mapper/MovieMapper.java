package com.kadirgurturk.MovieApp.mapper;

import com.kadirgurturk.MovieApp.dto.Iterable.DirectorListDTO;
import com.kadirgurturk.MovieApp.dto.Iterable.MoviesDto;
import com.kadirgurturk.MovieApp.dto.MovieDto;
import com.kadirgurturk.MovieApp.dto.Save.SaveMovie;
import com.kadirgurturk.MovieApp.entity.Movie;
import com.kadirgurturk.MovieApp.entity.dto.DirectorList;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieMapper {

    public MovieDto toMovieDto(Movie movie)
    {
        var dto = new MovieDto();

        dto.movieName = movie.getMovieName();
        dto.sceneDate = movie.getSceneDate();
        dto.cost = movie.getCost();
        dto.imdb = movie.getImdb();
        dto.rating = movie.getRating();

        return dto;
    }

    public MoviesDto toMoviesDto(List<MovieDto> moviesDto)
    {
        var dto = new MoviesDto();
        dto.moviesDto = moviesDto;

        return dto;
    }

    public DirectorListDTO toMovieListDto(List<DirectorList> directorList)
    {
        var dto = new DirectorListDTO();
        dto.directorListDto = directorList;

        return dto;
    }

    public Movie toMovie(SaveMovie moveSave)
    {
        return new Movie(moveSave.movieName,moveSave.sceneDate,moveSave.rating,moveSave.cost,moveSave.imdb);
    }
}
