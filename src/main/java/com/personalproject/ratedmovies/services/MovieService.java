package com.personalproject.ratedmovies.services;

import com.personalproject.ratedmovies.dto.MovieDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class MovieService {

    public List<MovieDTO> movies = new ArrayList<>();

    public List <MovieDTO> getAllMovies() {
        return movies;
    }

    public MovieDTO addMovie(MovieDTO movie) {
        MovieDTO newMovie = new MovieDTO(
                movie.getName(),
                movie.getYear(),
                movie.getCategory(),
                movie.getSynopsis(),
                movie.getDirector(),
                movie.getNationality(),
                movie.getRate()
        );

        movies.add(newMovie);
        return newMovie;
    }
}
