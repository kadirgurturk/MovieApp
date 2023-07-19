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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/api/movies/")
public class MoiveController {
    private MovieService movieService;
    private MoviestoDirectorService moviestoDirectorService;

    public MoiveController(MovieService movieService, MoviestoDirectorService moviestoDirectorService) {
        this.movieService = movieService;
        this.moviestoDirectorService = moviestoDirectorService;
    }

    @GetMapping("count")
    public ResponseEntity<?> count(){

        return new ResponseEntity<>(movieService.count(),HttpStatus.OK);
    }


    @GetMapping()
    public ResponseEntity<?> findByName(@RequestParam("n") String name){

        return new ResponseEntity<>(movieService.findByName(name), HttpStatus.FOUND);
    }

    @GetMapping("movie/")
    public ResponseEntity<?>  findById(@RequestParam("id") Long id){

        var movie = movieService.findById(id).orElseThrow(() -> new NotFoundExp("This id is not vaild") );

        return new ResponseEntity<>(movie,HttpStatus.FOUND);
    }

    @GetMapping("movie/rating/")
    public ResponseEntity<?> findByRating(@RequestParam("rate") Long rating){

        return new ResponseEntity<>(movieService.findByRating(rating),HttpStatus.FOUND);
    }

    @GetMapping("movie/directors/{id}")
    public ResponseEntity<?> findMovieById(@PathVariable("id") Long id)
    {
        return new ResponseEntity<>(movieService.findDirectorsById(id),HttpStatus.FOUND);

    }

    @GetMapping("page/")
    public ResponseEntity<?> findMovieSort(@RequestParam("p") int page, @RequestParam("s") int size)
    {

        return new ResponseEntity<>(movieService.moviesPagination(page,size),HttpStatus.FOUND);

    }

    @GetMapping("sort/")
    public ResponseEntity<?> findMovieWithSort(@RequestParam("f") String field)
    {
        return new ResponseEntity<>(movieService.movieSort(field),HttpStatus.FOUND);

    }

    @GetMapping("pagesort/")
    public ResponseEntity<?> findMoviePaginationSort(@RequestParam("p") int page, @RequestParam("s") int size,@RequestParam("f") String field)
    {
        return new ResponseEntity<>(movieService.moviesSortPagination(page,size,field),HttpStatus.FOUND);

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
