package com.personalproject.ratedmovies.services;

import com.personalproject.ratedmovies.dto.mappers.MovieMapper;
import com.personalproject.ratedmovies.dto.requests.MovieRequestDTO;
import com.personalproject.ratedmovies.dto.responses.MovieResponseDTO;
import com.personalproject.ratedmovies.models.Movie;
import com.personalproject.ratedmovies.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    private MovieMapper movieMapper;

    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    public List<MovieResponseDTO> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream().map(movieMapper::toResponseDTO).collect(Collectors.toList());
    }

    public MovieResponseDTO addMovie(MovieRequestDTO movieDTO) {
        Movie movie = movieMapper.toEntity(movieDTO);
        Movie addedMovie = movieRepository.save(movie);
        return movieMapper.toResponseDTO(addedMovie);
    }
}
