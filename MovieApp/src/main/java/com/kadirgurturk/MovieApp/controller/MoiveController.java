package com.kadirgurturk.MovieApp.controller;

import com.kadirgurturk.MovieApp.advice.exceptions.NotFoundExp;
import com.kadirgurturk.MovieApp.dto.Iterable.DirectorListDTO;
import com.kadirgurturk.MovieApp.dto.Iterable.MoviesDto;
import com.kadirgurturk.MovieApp.dto.MovieDto;
import com.kadirgurturk.MovieApp.dto.Save.MoviesDirectorSave;
import com.kadirgurturk.MovieApp.dto.Save.SaveMovie;
import com.kadirgurturk.MovieApp.entity.dto.MoviesDirector;
import com.kadirgurturk.MovieApp.service.MovieService;
import com.kadirgurturk.MovieApp.service.MoviestoDirectorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/api/movies")
public class MoiveController {
    private MovieService movieService;
    private MoviestoDirectorService moviestoDirectorService;

    public MoiveController(MovieService movieService, MoviestoDirectorService moviestoDirectorService) {
        this.movieService = movieService;
        this.moviestoDirectorService = moviestoDirectorService;
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
    public MovieDto findById(@RequestParam("id") Long id){

        return movieService.findById(id)
                .orElseThrow(() -> new NotFoundExp("This id is not valid"));
    }

    @GetMapping("findByRating/")
    public MoviesDto findByRating(@RequestParam("rate") Long rating){
        return movieService.findByRating(rating);
    }

    @GetMapping("movie/find/directors/{id}")
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
    public ResponseEntity<SaveMovie> saveMovie(@RequestBody @Valid SaveMovie movieSave){

           movieService.save(movieSave);

          return ResponseEntity.ok(movieSave);

    }

    @PostMapping("movietodirector/save")
    public ResponseEntity<MoviesDirectorSave> saveMoviesDirector(@RequestBody MoviesDirectorSave save)
    {

        moviestoDirectorService.SaveMoveitoDirector(save);

        return ResponseEntity.ok(save);
    }
}
