package com.kadirgurturk.MovieApp.controller;

import com.kadirgurturk.MovieApp.advice.exceptions.NotFoundExp;
import com.kadirgurturk.MovieApp.dto.DirectorDto;
import com.kadirgurturk.MovieApp.dto.Iterable.DirectorsDTO;
import com.kadirgurturk.MovieApp.dto.Iterable.MovieListDTO;
import com.kadirgurturk.MovieApp.dto.Save.SaveDirector;
import com.kadirgurturk.MovieApp.service.DirectorService;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/directors")
public class DirectorController {
    private DirectorService directorService;


    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping("director/id/")
    public DirectorDto findById(@RequestParam("id") Long id)
    {
        return directorService.findById(id).orElseThrow(() -> new NotFoundExp("This id is not valid"));
    }

    @GetMapping("director/movie/id/")
    public MovieListDTO findMovieById(@RequestParam("id") Long id)
    {
        return directorService.findMoviesById(id);
    }

    @GetMapping("director/name/")
    public DirectorsDTO findDirectorByName(@RequestParam("n") String name)
    {
        return directorService.findByName(name);
    }

    @PostMapping("director/save")
    public ResponseEntity<SaveDirector> saveDirector(@RequestBody @Valid SaveDirector director)
    {

        directorService.save(director);

        return ResponseEntity.ok(director);
    }

}
