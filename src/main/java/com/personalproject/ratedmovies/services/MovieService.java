package com.personalproject.ratedmovies.services;

import com.personalproject.ratedmovies.dto.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    public List<MovieDTO> movies = new ArrayList<>();

    public List <MovieDTO> getAllMovies() {
        return movies;
    }

    public MovieDTO addMovie(MovieDTO movie) {
        movies.add(movie);
        return movie;
    }
}