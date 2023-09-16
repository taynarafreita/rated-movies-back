package com.personalproject.ratedmovies.dto;

import com.personalproject.ratedmovies.enums.MovieCategoryEnum;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

public class MovieDTO {
    private UUID id;
    @Size(max = 200, message = "Name must have a maximum of 200 characters")
    private String name;
    private Integer year;
    private MovieCategoryEnum category;
    @Size(max = 200, message = "Director must have a maximum of 200 characters")
    private String director;
    @Size(max = 50, message = "Nacionality must have a maximum of 50 characters")
    private String nacionality;
    @DecimalMin(value = "0.0", message = "Rate must be between 0 and 5.0")
    @DecimalMax(value = "5.0", message = "Rate must be between 0 and 5.0")
    private Double rate;
    private LocalDateTime createdAt;

    public MovieDTO() {}

    public MovieDTO(String name, Integer year, MovieCategoryEnum category, String director,
                    String nacionality, Double rate) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.year = year;
        this.category = category;
        this.director = director;
        this.nacionality = nacionality;
        this.rate = rate;
        this.createdAt = LocalDateTime.now();
    }

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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getNacionality() {
        return nacionality;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
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
}
