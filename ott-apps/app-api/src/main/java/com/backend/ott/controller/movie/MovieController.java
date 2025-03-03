package com.backend.ott.controller.movie;

import com.backend.ott.controller.OttApiResponse;
import com.backend.ott.movie.FetchMovieUseCase;
import com.backend.ott.movie.response.PageableMoviesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final FetchMovieUseCase fetchMovieUseCase;

    @GetMapping("/api/v1/movie/client/{page}")
    public OttApiResponse<PageableMoviesResponse> fetchMoviePageables(@PathVariable int page) {
        PageableMoviesResponse pageableMoviesResponse = fetchMovieUseCase.fetchFromClient(page);
        return OttApiResponse.ok(pageableMoviesResponse);
    }
}