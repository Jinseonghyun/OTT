package com.backend.ott.repository.movie;

import com.backend.ott.entity.movie.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieJpaRepository extends JpaRepository<MovieEntity, String> {
    Optional<MovieEntity> findByMovieName(String movieName);
}
