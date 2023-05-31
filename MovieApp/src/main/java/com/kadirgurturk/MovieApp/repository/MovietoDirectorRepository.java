package com.kadirgurturk.MovieApp.repository;

import com.kadirgurturk.MovieApp.entity.MoviestoDirector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MovietoDirectorRepository extends JpaRepository<MoviestoDirector,Long> {
}
