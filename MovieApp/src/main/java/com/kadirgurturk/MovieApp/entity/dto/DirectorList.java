package com.kadirgurturk.MovieApp.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;

import java.time.LocalDate;

public class DirectorList {


    public String firstName;

    public String middleName;

    public String familyName;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    public LocalDate birthDate;

    public DirectorList(String firstName, String middleName, String familyName, LocalDate birthDate) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.familyName = familyName;
        this.birthDate = birthDate;
    }
}
