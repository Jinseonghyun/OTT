package com.backend.ott.movie.response;

import lombok.Getter;

import java.util.List;

@Getter
public class PageableMoviesResponse {

    private final List<MovieResponse> movieResponses; // 조회한 영화 데이터
    private final int page; // 현재 어떤 페이지 조회
    private final boolean hasNext; // 다음 페이지가 있는지 없는지

    public PageableMoviesResponse(List<MovieResponse> movieResponses, int page, boolean hasNext) {
        this.movieResponses = movieResponses;
        this.page = page;
        this.hasNext = hasNext;
    }
}
