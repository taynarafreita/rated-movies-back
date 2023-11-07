package com.personalproject.ratedmovies.dto.requests;

import com.personalproject.ratedmovies.enums.MovieCategoryEnum;
import com.personalproject.ratedmovies.interfaces.ValidCategoryEnum;
import com.personalproject.ratedmovies.interfaces.ValidYear;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class MovieRequestDTO {

    @NotBlank(message = "is required")
    @Size(max = 200, message = "must have a maximum of 200 characters")
    private String name;

    @ValidYear(message = "must be a number")
    @NotNull(message = "is required")
    private Integer year;

    @ValidCategoryEnum(message = "must be a CategoryEnum")
    @NotNull(message = "is required")
    private MovieCategoryEnum category;

    private String synopsis;

    @NotNull(message = "is required")
    @Size(max = 200, message = "must have a maximum of 200 characters")
    private String director;

    @NotNull(message = "is required")
    @Size(max = 50, message = "must have a maximum of 50 characters")
    private String nationality;

    @NotNull(message = "is required")
    @DecimalMin(value = "0.0", message = "must be between 0 and 5.0")
    @DecimalMax(value = "5.0", message = "must be between 0 and 5.0")
    private Double rate;

    public MovieRequestDTO() {}

    public MovieRequestDTO(String name, Integer year, MovieCategoryEnum category, String synopsis, String director,
                            String nationality, Double rate) {
        this.name = name;
        this.year = year;
        this.category = category;
        this.synopsis = synopsis;
        this.director = director;
        this.nationality = nationality;
        this.rate = rate;
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
