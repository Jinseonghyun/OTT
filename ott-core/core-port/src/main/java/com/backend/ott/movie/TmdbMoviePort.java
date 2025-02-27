package com.backend.ott.movie;

public interface TmdbMoviePort {
    TmdbPageableMovies fetchPageable(int page);
}
