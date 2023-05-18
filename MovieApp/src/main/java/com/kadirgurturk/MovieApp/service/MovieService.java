package com.kadirgurturk.MovieApp.service;

import com.kadirgurturk.MovieApp.dto.Iterable.DirectorListDTO;
import com.kadirgurturk.MovieApp.dto.Iterable.MoviesDto;
import com.kadirgurturk.MovieApp.dto.MovieDto;
import com.kadirgurturk.MovieApp.dto.Save.SaveMovie;
import com.kadirgurturk.MovieApp.entity.Movie;
import com.kadirgurturk.MovieApp.mapper.MovieMapper;
import com.kadirgurturk.MovieApp.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieService {

    private MovieMapper movieMapper;
    private MovieRepository movieRepository;

    public MovieService(MovieMapper movieMapper, MovieRepository movieRepository) {
        this.movieMapper = movieMapper;
        this.movieRepository = movieRepository;
    }

    public void save(SaveMovie saveMovie)
    {

        var movie = new Movie(saveMovie.movieName,saveMovie.sceneDate,saveMovie.rating,saveMovie.cost,saveMovie.imdb);

        movieRepository.save(movie);

    }

    public Long count()
    {
        return movieRepository.count();
    }

    public Optional<MovieDto> findById(Long id)
    {
        return movieRepository.findById(id).map(movieMapper::toMovieDto);
    }

    public MoviesDto findByRating(Long rating)
    {
        return movieMapper.toMoviesDto(StreamSupport.stream(movieRepository.findByRating(rating).spliterator(),false).map(movieMapper::toMovieDto).collect(Collectors.toList()));
    }

    public MoviesDto findByName(String name)
    {
        return movieMapper.toMoviesDto(StreamSupport.stream(movieRepository.findByMovieName(name).spliterator(),false).map(movieMapper::toMovieDto).collect(Collectors.toList()));
    }

    public DirectorListDTO findDirectorsById(Long id)
    {
        return movieMapper.toMovieListDto(StreamSupport.stream(movieRepository.findByIdWithMovies(id).spliterator(),false).collect(Collectors.toList()));
    }


}
