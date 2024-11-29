package com.appiCorp.repository;

import com.appiCorp.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface MovieRepository extends JpaRepository<MovieEntity, UUID> {

    @Query("SELECT m.director, COUNT(m) FROM MovieEntity m GROUP BY m.director HAVING COUNT(m) >= :minMovies")
    List<Object[]> findDirectorsWithAtLeast(@Param("minMovies") long minMovies);
}
