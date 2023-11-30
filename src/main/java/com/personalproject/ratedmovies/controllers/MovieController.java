package com.personalproject.ratedmovies.controllers;

import com.personalproject.ratedmovies.commons.ErrorResponse;
import com.personalproject.ratedmovies.dto.mappers.MovieMapper;
import com.personalproject.ratedmovies.dto.requests.MovieRequestDTO;
import com.personalproject.ratedmovies.dto.requests.MovieUpdateRequestDTO;
import com.personalproject.ratedmovies.dto.responses.MovieResponseDTO;
import com.personalproject.ratedmovies.dto.responses.MovieUpdateResponseDTO;
import com.personalproject.ratedmovies.services.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @GetMapping
    public List<MovieResponseDTO> getAllmovies() {
        return movieService.getAllMovies();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMovie(@Valid @RequestBody MovieRequestDTO movieRequestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors().stream()
                    .map(error -> error.getField() + " " + error.getDefaultMessage())
                    .collect(Collectors.toList());

            ErrorResponse errorResponse = new ErrorResponse("BadRequest", errors);
            return ResponseEntity.badRequest().body(errorResponse);

        } else {
            MovieResponseDTO addedMovie = movieService.addMovie((movieRequestDto));
            return ResponseEntity.status(HttpStatus.CREATED).body(addedMovie);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateMovie(@Valid @RequestBody MovieUpdateRequestDTO updatedMovie, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors().stream()
                    .map(error -> error.getField() + " " + error.getDefaultMessage())
                    .collect(Collectors.toList());

            ErrorResponse errorResponse = new ErrorResponse("BadRequest", errors);
            return ResponseEntity.badRequest().body(errorResponse);
        } else {
            UUID movieId = updatedMovie.getId();
            MovieUpdateResponseDTO updatedMovieResponse = movieService.updateMovie(updatedMovie);
            if (updatedMovieResponse != null) {
                return ResponseEntity.ok(updatedMovieResponse);
            } else {
                return ResponseEntity.notFound().build();
        }}
    }
}
