package com.kadirgurturk.MovieApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.*;

import java.time.LocalDate;

public class SaveDirector {

    @NotNull(message = "firstName can not be null")
    public String firstName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String middleName;

    @NotNull(message = "lastname can not be null")
    public String familyName;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @NotNull(message = "birthdate can not be null")
    public LocalDate birthDate;

    public SaveDirector(String firstName, String middleName, String familyName, LocalDate birthDate) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.familyName = familyName;
        this.birthDate = birthDate;
    }

    public SaveDirector() {
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
}
