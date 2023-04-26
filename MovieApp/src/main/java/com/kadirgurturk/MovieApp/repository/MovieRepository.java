package com.kadirgurturk.MovieApp.repository;

import com.kadirgurturk.MovieApp.entity.Movie;
import com.kadirgurturk.MovieApp.entity.dto.DirectorList;
import com.kadirgurturk.MovieApp.entity.dto.MovieList;
import com.kadirgurturk.MovieApp.entity.dto.MoviesDirector;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends CrudRepository<Movie,Long> {


    Iterable<Movie> findByRating(Long rating);

    Iterable<Movie> findByMovieName(String name);

    @Override
    Optional<Movie> findById(Long aLong);

    @Query("""
    select new com.kadirgurturk.MovieApp.entity.dto.DirectorList(d.firstName, d.middleName, d.familyName, d.birthDate)
    from Director d join d.movies m where m.movieId = :id
        """)
    public Iterable<DirectorList> findByIdWithMovies(@Param("id") Long id);

    @Query("""
    select new com.kadirgurturk.MovieApp.entity.dto.MoviesDirector(m.movieName, m.sceneDate, m.cost, d)
    from Movie m 
    join m.directors d 
    where m.movieId = :id
        """)
    public Optional<MoviesDirector> findMovieByIdWithDirector(@Param("id") Long id);


    @Override
    long count();
}
