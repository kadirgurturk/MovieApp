package com.kadirgurturk.MovieApp.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "movies_to_director")
public class MoviestoDirector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movies_to_director_id", nullable = false)
    public long id;

    @Column(name = "movie_id", nullable = false)
    public long movieId;

    @Column(name = "director_id", nullable = false)
    public long directorId;

    public MoviestoDirector() {
    }

    public MoviestoDirector( long movieId, long directorId) {

        this.movieId = movieId;
        this.directorId = directorId;
    }
}
