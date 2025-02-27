package com.backend.ott.movie;

import lombok.Getter;

import java.util.List;

@Getter
public class TmdbPageableMovies {

    private final List<TmdbMovie> tmdbMovies; // 조회한 영화 데이터
    private final int page; // 현재 어떤 페이지 조회
    private final boolean hasNext; // 다음 페이지가 있는지 없는지

    public TmdbPageableMovies(List<TmdbMovie> tmdbMovies, int page, boolean hasNext) {
        this.tmdbMovies = tmdbMovies;
        this.page = page;
        this.hasNext = hasNext;
    }
}
