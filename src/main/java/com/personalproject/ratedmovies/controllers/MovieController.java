package com.personalproject.ratedmovies.controllers;

import com.personalproject.ratedmovies.dto.MovieDTO;
import com.personalproject.ratedmovies.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieDTO> getAllmovies() {
        return movieService.getAllMovies();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDTO addMovie(@RequestBody MovieDTO movie) {
       return movieService.addMovie(movie);
    }
}
