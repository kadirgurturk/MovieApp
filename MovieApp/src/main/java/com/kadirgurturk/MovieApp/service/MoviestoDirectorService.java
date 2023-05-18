package com.kadirgurturk.MovieApp.service;

import com.kadirgurturk.MovieApp.advice.exceptions.NotFoundExp;
import com.kadirgurturk.MovieApp.dto.Save.MoviesDirectorSave;
import com.kadirgurturk.MovieApp.entity.MoviestoDirector;
import com.kadirgurturk.MovieApp.repository.MovietoDirectorRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MoviestoDirectorService {

    private DirectorService directorService;
    private MovieService movieService;
    private MovietoDirectorRepository movietoDirectorRepository;

    public MoviestoDirectorService(DirectorService directorService, MovieService movieService, MovietoDirectorRepository movietoDirectorRepository) {
        this.directorService = directorService;
        this.movieService = movieService;
        this.movietoDirectorRepository = movietoDirectorRepository;
    }

    @Transactional
    public ResponseEntity<?> SaveMoveitoDirector(MoviesDirectorSave moviesDirectorSave)
    {
        if(movieService.findById(moviesDirectorSave.movieId).isEmpty()){
            throw new NotFoundExp("movie is not found");
        }

        if(directorService.findById(moviesDirectorSave.directorId).isEmpty()){
            throw new NotFoundExp("director is not found");
        }

        var movietoDirector = new MoviestoDirector(moviesDirectorSave.movieId, moviesDirectorSave.directorId);

        movietoDirectorRepository.save(movietoDirector);

        return ResponseEntity.ok("Saved");
    }
}
