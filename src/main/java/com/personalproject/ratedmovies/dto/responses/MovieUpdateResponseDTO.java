package com.personalproject.ratedmovies.dto.responses;

import com.personalproject.ratedmovies.enums.MovieCategoryEnum;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

public class MovieUpdateResponseDTO {

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

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public MovieUpdateResponseDTO(String name, Integer year, MovieCategoryEnum category, String synopsis, String director,
                            String nationality, Double rate, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.year = year;
        this.category = category;
        this.synopsis = synopsis;
        this.director = director;
        this.nationality = nationality;
        this.rate = rate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
