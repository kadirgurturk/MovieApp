package com.kadirgurturk.MovieApp.dto.Iterable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kadirgurturk.MovieApp.entity.Director;
import com.kadirgurturk.MovieApp.entity.dto.DirectorList;

import java.util.List;

public class DirectorListDTO {

    @JsonProperty("movies_directors")
    public List<DirectorList> directorListDto;

}
