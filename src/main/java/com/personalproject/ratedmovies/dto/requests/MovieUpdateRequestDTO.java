package com.personalproject.ratedmovies.dto.requests;

import com.personalproject.ratedmovies.enums.MovieCategoryEnum;
import jakarta.validation.constraints.*;

import java.util.UUID;

public class MovieUpdateRequestDTO {

    private UUID id;

    @Size(max = 200, message = "must have a maximum of 200 characters")
    private String name;

    private Integer year;

    private MovieCategoryEnum category;

    private String synopsis;

    @Size(max = 200, message = "must have a maximum of 200 characters")
    private String director;

    @Size(max = 50, message = "must have a maximum of 50 characters")
    private String nationality;

    @DecimalMin(value = "0.0", message = "must be between 0 and 5.0")
    @DecimalMax(value = "5.0", message = "must be between 0 and 5.0")
    private Double rate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public MovieCategoryEnum getCategory() {
        return category;
    }

    public void setCategory(MovieCategoryEnum category) {
        this.category = category;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
