package com.personalproject.ratedmovies.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class MovieDTO {
    private UUID id;
    private String name;
    private Integer year;
    private String category;
    private String director;
    private String nacionality;
    private Double rate;
    private LocalDateTime createdAt;

    public MovieDTO() {}

    public MovieDTO(String name, Integer year, String category, String director,
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
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
