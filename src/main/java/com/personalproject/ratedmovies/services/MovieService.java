package com.personalproject.ratedmovies.services;

import com.personalproject.ratedmovies.dto.mappers.MovieMapper;
import com.personalproject.ratedmovies.dto.requests.MovieRequestDTO;
import com.personalproject.ratedmovies.dto.requests.MovieUpdateRequestDTO;
import com.personalproject.ratedmovies.dto.responses.MovieResponseDTO;
import com.personalproject.ratedmovies.dto.responses.MovieUpdateResponseDTO;
import com.personalproject.ratedmovies.models.Movie;
import com.personalproject.ratedmovies.repositories.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
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

    @Transactional
    public MovieUpdateResponseDTO updateMovie(MovieUpdateRequestDTO updatedMovie) {
        UUID movieId = updatedMovie.getId();
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found"));

        if (updatedMovie.getName() != null) {
            movie.setName(updatedMovie.getName());
        }
        if (updatedMovie.getYear() != null) {
            movie.setYear(updatedMovie.getYear());
        }
        if (updatedMovie.getCategory() != null) {
            movie.setCategory(updatedMovie.getCategory());
        }
        if (updatedMovie.getSynopsis() != null) {
            movie.setSynopsis(updatedMovie.getSynopsis());
        }
        if (updatedMovie.getDirector() != null) {
            movie.setDirector(updatedMovie.getDirector());
        }
        if (updatedMovie.getNationality() != null) {
            movie.setNationality(updatedMovie.getNationality());
        }
        if (updatedMovie.getRate() != null) {
            movie.setRate(updatedMovie.getRate());
        }

        movieRepository.save(movie);
        return movieMapper.toResponseUpdateDTO(movie);

    }
}
