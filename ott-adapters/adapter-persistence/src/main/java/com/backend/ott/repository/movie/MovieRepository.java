package com.backend.ott.repository.movie;

import com.backend.ott.entity.movie.MovieEntity;
import com.backend.ott.movie.OttMovie;
import com.backend.ott.movie.PersistenceMoviePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MovieRepository implements PersistenceMoviePort {

    private final MovieJpaRepository movieJpaRepository;

    @Override
    @Transactional
    public List<OttMovie> fetchBy(int page, int size) {
        return movieJpaRepository.search(PageRequest.of(page, size)).stream().map(MovieEntity::toDomain).toList();
    }

    @Override
    public OttMovie findBy(String movieName) {
        return movieJpaRepository.findByMovieName(movieName)
                .map(MovieEntity::toDomain)
                .orElseThrow();
    }

    @Override
    @Transactional
    public void insert(OttMovie ottMovie) {
        Optional<MovieEntity> byMovieName = movieJpaRepository.findByMovieName(ottMovie.getMovieName());

        if (byMovieName.isPresent()) {
            return;
        }

        MovieEntity movieEntity = MovieEntity.newEntity(
                ottMovie.getMovieName(),
                ottMovie.getIsAdult(),
                ottMovie.getGenre(),
                ottMovie.getOverview(),
                ottMovie.getReleasedAt()
        );

        movieJpaRepository.save(movieEntity);
    }
}
