package com.personalproject.ratedmovies.dto;

import com.personalproject.ratedmovies.enums.MovieCategoryEnum;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.UUID;

public class MovieDTO {
    private UUID id;
    @NotBlank(message = "is required")
    @Size(max = 200, message = "must have a maximum of 200 characters")
    private String name;
   @NotNull(message = "is required")
    private Integer year;
   @NotNull(message = "is required")
   private MovieCategoryEnum category;
    private String synopsis;
    @NotNull(message = "is required")
    @Size(max = 200, message = "must have a maximum of 200 characters")
    private String director;
    @NotNull(message = "is required")
    @Size(max = 50, message = "must have a maximum of 50 characters")
    private String nacionality;
    @NotNull(message = "is required")
    @DecimalMin(value = "0.0", message = "must be between 0 and 5.0")
    @DecimalMax(value = "5.0", message = "must be between 0 and 5.0")
    private Double rate;
    private LocalDateTime createdAt;

    public MovieDTO() {}

    public MovieDTO(String name, Integer year, MovieCategoryEnum category, String synopsis, String director,
                    String nacionality, Double rate) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.year = year;
        this.category = category;
        this.synopsis = synopsis;
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
