package com.kadirgurturk.MovieApp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

//create table if not exists directors (
//    director_id bigserial primary key,
//    first_name varchar(100) not null,
//    middle_name varchar(100),
//    family_name varchar(100) not null,
//    birth_date date not null
//);


@Entity
@Table(name = "directors")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "director_id")
    public Long directorId;

    @Column(name = "first_name", nullable = false, length = 100)
    public String firstName;

    @Column(name = "middle_name", length = 100)
    public String middleName;

    @Column(name = "family_name",nullable = false, length = 100)
    public String familyName;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @Column(name = "birth_date",nullable = false)
    public LocalDate birthDate;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movies_to_director",
            joinColumns = @JoinColumn(name = "director_id",referencedColumnName = "director_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id",referencedColumnName = "movie_id"))
    private Set<Movie> movies ;

    public Director() {
    }

    public Long getDirectorİd() {
        return directorId;
    }

    public void setDirectorİd(Long directorİd) {
        this.directorId = directorİd;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
