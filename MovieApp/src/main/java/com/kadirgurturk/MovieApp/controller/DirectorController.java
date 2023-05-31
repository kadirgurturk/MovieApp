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

import java.util.List;

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

    @GetMapping("director/page/")
    public DirectorsDTO findDirectorWithPage(@RequestParam("p") int page, @RequestParam("s") int size)
    {
        return directorService.directorPagination(page,size);
    }

    @GetMapping("director/pagesort/")
    public DirectorsDTO findDirectorWithPageAndSort(@RequestParam("p") int page, @RequestParam("s") int size, @RequestParam("f") String field)
    {
        return directorService.directorsSortPage(page,size,field);
    }

    @PostMapping("director/save")
    public ResponseEntity<SaveDirector> saveDirector(@RequestBody @Valid SaveDirector director)
    {

        directorService.save(director);

        return ResponseEntity.ok(director);
    }

}
