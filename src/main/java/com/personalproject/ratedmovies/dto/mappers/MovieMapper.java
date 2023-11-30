package com.personalproject.ratedmovies.dto.mappers;

import com.personalproject.ratedmovies.dto.requests.MovieRequestDTO;
import com.personalproject.ratedmovies.dto.requests.MovieUpdateRequestDTO;
import com.personalproject.ratedmovies.dto.responses.MovieResponseDTO;
import com.personalproject.ratedmovies.dto.responses.MovieUpdateResponseDTO;
import com.personalproject.ratedmovies.models.Movie;
import com.personalproject.ratedmovies.repositories.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;
@Component
public class MovieMapper {

    private final MovieRepository movieRepository;

    public MovieMapper(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie toEntity(MovieRequestDTO dto) {
        Movie movie = new Movie();
        movie.setId(UUID.randomUUID());
        movie.setName(dto.getName());
        movie.setYear(dto.getYear());
        movie.setCategory(dto.getCategory());
        movie.setSynopsis(dto.getSynopsis());
        movie.setDirector(dto.getDirector());
        movie.setNationality(dto.getNationality());
        movie.setRate(dto.getRate());
        return movie;
    }

    public MovieResponseDTO toResponseDTO(Movie movie) {
        return new MovieResponseDTO(
                movie.getId(),
                movie.getName(),
                movie.getYear(),
                movie.getCategory(),
                movie.getSynopsis(),
                movie.getDirector(),
                movie.getNationality(),
                movie.getRate(),
                movie.getCreatedAt(),
                movie.getUpdatedAt()
        );
    }

    public Movie toEntityUpdate(MovieUpdateRequestDTO dto) {
        UUID movieId = dto.getId();

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found"));

        movie.setName(dto.getName());
        movie.setYear(dto.getYear());
        movie.setCategory(dto.getCategory());
        movie.setSynopsis(dto.getSynopsis());
        movie.setDirector(dto.getDirector());
        movie.setNationality(dto.getNationality());
        movie.setRate(dto.getRate());

        return movie;
    }

    public MovieUpdateResponseDTO toResponseUpdateDTO(Movie movie) {
        return new MovieUpdateResponseDTO(
                movie.getName(),
                movie.getYear(),
                movie.getCategory(),
                movie.getSynopsis(),
                movie.getDirector(),
                movie.getNationality(),
                movie.getRate(),
                movie.getCreatedAt(),
                movie.getUpdatedAt()
        );
    }
}
