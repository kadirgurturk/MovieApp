package com.kadirgurturk.MovieApp.controller;

import com.kadirgurturk.MovieApp.dto.Iterable.DirectorListDTO;
import com.kadirgurturk.MovieApp.dto.Iterable.MoviesDto;
import com.kadirgurturk.MovieApp.dto.MovieDto;
import com.kadirgurturk.MovieApp.entity.Movie;
import com.kadirgurturk.MovieApp.entity.dto.DirectorList;
import com.kadirgurturk.MovieApp.entity.dto.MovieList;
import com.kadirgurturk.MovieApp.entity.dto.MoviesDirector;
import com.kadirgurturk.MovieApp.repository.MovieRepository;
import com.kadirgurturk.MovieApp.service.MovieService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/api/movies")
public class MoiveController {
    private MovieService movieService;

    public MoiveController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("count")
    public Long count(){
        return movieService.count();
    }


    @GetMapping("findByName/")
    public MoviesDto findAll(@RequestParam("n") String name){
        return movieService.findByName(name);
    }

    @GetMapping("findByid/")
    public Optional<MovieDto> findById(@RequestParam("id") Long id){
        return movieService.findById(id);
    }

    @GetMapping("findByRating/")
    public MoviesDto findByRating(@RequestParam("rate") Long rating){
        return movieService.findByRating(rating);
    }

    @GetMapping("movie/find/director/{id}")
    public DirectorListDTO findMovieById(@PathVariable("id") Long id)
    {
        return movieService.findDirectorsById(id);
    }

    @GetMapping("findMovieByIdWithDirector/")
    public Optional<MoviesDirector> findMovieByIdWithDirector(@RequestParam("id") Long id)
    {
        // TODO: 27.04.2023  r
        return null;
    }

    @PostMapping("movie/save")
    public String saveMovie(@RequestBody Movie movieSave){
        {
            movieService.save(movieSave);

            if(movieSave.getDirectors() == null){
                return "null";
            }else{
                return "değil";
            }
        }

    }
}
