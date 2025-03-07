package com.backend.ott.movie;

import com.backend.ott.movie.response.MovieResponse;

import java.util.List;

public interface InsertMovieUseCase {
    void insert(List<MovieResponse> items);
}
