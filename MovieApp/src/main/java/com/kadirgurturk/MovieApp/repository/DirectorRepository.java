package com.kadirgurturk.MovieApp.repository;

import com.kadirgurturk.MovieApp.entity.Director;
import com.kadirgurturk.MovieApp.entity.dto.MovieList;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Long> {

    @Transactional
    @Override
    Optional<Director> findById(Long aLong);


    Iterable<Director> findByfirstName(String name);

    @Query("""
    select new com.kadirgurturk.MovieApp.entity.dto.MovieList(m.movieName, m.sceneDate, m.cost)
    from Movie m join m.directors d where d.directorId = :id
        """)
    public Iterable<MovieList> findByIdWithMovies(@Param("id") Long id);

}
