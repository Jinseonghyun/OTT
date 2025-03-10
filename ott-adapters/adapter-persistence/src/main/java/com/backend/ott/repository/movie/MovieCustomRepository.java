package com.backend.ott.repository.movie;

import com.backend.ott.entity.movie.MovieEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MovieCustomRepository {
    Optional<MovieEntity> findByMovieName(String Name);

    Page<MovieEntity> search(Pageable pageable);
}
