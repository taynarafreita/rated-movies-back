package com.personalproject.ratedmovies.dto.mappers;

import com.personalproject.ratedmovies.dto.requests.MovieRequestDTO;
import com.personalproject.ratedmovies.dto.responses.MovieResponseDTO;
import com.personalproject.ratedmovies.models.Movie;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;
@Component
public class MovieMapper {

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
}
