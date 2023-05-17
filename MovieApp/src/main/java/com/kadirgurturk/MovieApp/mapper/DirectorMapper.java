package com.kadirgurturk.MovieApp.mapper;

import com.kadirgurturk.MovieApp.dto.DirectorDto;
import com.kadirgurturk.MovieApp.dto.Iterable.DirectorsDTO;
import com.kadirgurturk.MovieApp.dto.Iterable.MovieListDTO;
import com.kadirgurturk.MovieApp.dto.SaveDirector;
import com.kadirgurturk.MovieApp.entity.Director;
import com.kadirgurturk.MovieApp.entity.dto.DirectorList;
import com.kadirgurturk.MovieApp.entity.dto.MovieList;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DirectorMapper {
    public  DirectorDto toDirectorDto(Director director)
    {
        var Dto = new DirectorDto();

        Dto.firstName = director.firstName;
        Dto.middleName = director.middleName;
        Dto.familyName = director.familyName;
        Dto.birthDate = director.birthDate;

        return Dto;
    }

    public DirectorsDTO toDirectorsDTO(List<DirectorDto> directorDto )
    {
        var dto = new DirectorsDTO();

        dto.directorsDto = directorDto;

        return dto;
    }

    public MovieListDTO toMovieListDto(List<MovieList> moviesList)
    {
        var dto = new MovieListDTO();
        dto.movieListDto = moviesList;

        return dto;
    }

    public Director toDirector(SaveDirector directorSave)
    {
        return new Director(directorSave.firstName,directorSave.middleName,directorSave.familyName,directorSave.birthDate);
    }
}
