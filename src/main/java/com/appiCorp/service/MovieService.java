package com.appiCorp.service;

import com.appiCorp.dto.Movie;
import com.appiCorp.model.MovieEntity;
import com.appiCorp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Transactional
    public void saveMovies(List<Movie> movies) {
        movies.forEach(movie -> {
            MovieEntity movieEntity = new MovieEntity();
            movieEntity.setTitle(movie.getTitle());
            movieEntity.setYear(movie.getYear());
            movieEntity.setRated(movie.getRated());
            movieEntity.setReleased(movie.getReleased());
            movieEntity.setRuntime(movie.getRuntime());
            movieEntity.setGenre(movie.getGenre());
            movieEntity.setDirector(movie.getDirector());
            movieEntity.setWriter(movie.getWriter());
            movieEntity.setActors(movie.getActors());

            movieRepository.save(movieEntity);
        });

        System.out.println("Movies have been saved successfully.");
    }

    public List<Object[]> findDirectorsWithMovies(long minMovies) {
        return movieRepository.findDirectorsWithAtLeast(minMovies);
    }
}
