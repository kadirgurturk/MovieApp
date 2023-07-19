package com.kadirgurturk.MovieApp.service;

import com.kadirgurturk.MovieApp.dto.Iterable.DirectorListDTO;
import com.kadirgurturk.MovieApp.dto.Iterable.MoviesDto;
import com.kadirgurturk.MovieApp.dto.MovieDto;
import com.kadirgurturk.MovieApp.dto.Save.SaveMovie;
import com.kadirgurturk.MovieApp.entity.Movie;
import com.kadirgurturk.MovieApp.mapper.MovieMapper;
import com.kadirgurturk.MovieApp.repository.MovieRepository;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@CacheConfig(cacheNames = "movieCache")
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

    @Cacheable(cacheNames = "movies", key = "#id")
    public MoviesDto findByName(String name)
    {
        return movieMapper.toMoviesDto(StreamSupport.stream(movieRepository.findByMovieName(name).spliterator(),false).map(movieMapper::toMovieDto).collect(Collectors.toList()));
    }


    public MoviesDto moviesPagination(int page, int size)
    {

        var pageble = PageRequest.of(page,size);

       return movieMapper.toMoviesDto(StreamSupport.stream(movieRepository.findAll(pageble).spliterator(),false)
               .map(movieMapper::toMovieDto)
               .collect(Collectors.toList()));
    }

    public MoviesDto movieSort(String field)
    {
        return movieMapper.toMoviesDto(StreamSupport.stream(movieRepository.findAll(Sort.by(field)).spliterator(),false)
                .map(movieMapper::toMovieDto)
                .collect(Collectors.toList()));
    }

    public MoviesDto moviesSortPagination(int page, int size,String field)
    {
        var pageble = PageRequest.of(page,size);

        return movieMapper.toMoviesDto(StreamSupport.stream(movieRepository.findAll(pageble.withSort(Sort.by(field))).spliterator(),false)
                .map(movieMapper::toMovieDto)
                .collect(Collectors.toList()));
    }

    public DirectorListDTO findDirectorsById(Long id)
    {
        return movieMapper.toMovieListDto(StreamSupport.stream(movieRepository.findByIdWithMovies(id).spliterator(),false).collect(Collectors.toList()));
    }


}
