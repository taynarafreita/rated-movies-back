package com.personalproject.ratedmovies.repositories;

import com.personalproject.ratedmovies.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {

}
