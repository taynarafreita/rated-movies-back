package com.personalproject.ratedmovies.controllers;

import com.personalproject.ratedmovies.commons.ErrorResponse;
import com.personalproject.ratedmovies.dto.MovieDTO;
import com.personalproject.ratedmovies.services.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<?> addMovie(@Valid @RequestBody MovieDTO movie, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors().stream()
                    .map(error -> error.getField() + " " + error.getDefaultMessage())
                    .collect(Collectors.toList());

            ErrorResponse errorResponse = new ErrorResponse("BadRequest", errors);
            return ResponseEntity.badRequest().body(errorResponse);

        } else {
            MovieDTO addedMovie = movieService.addMovie((movie));
            return ResponseEntity.status(HttpStatus.CREATED).body(addedMovie);
        }
    }
}
