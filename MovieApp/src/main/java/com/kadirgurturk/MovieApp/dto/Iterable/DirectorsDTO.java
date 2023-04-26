package com.kadirgurturk.MovieApp.dto.Iterable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kadirgurturk.MovieApp.dto.DirectorDto;

import java.util.List;

public class DirectorsDTO {

    @JsonProperty("directors")
    public List<DirectorDto> directorsDto;


}
