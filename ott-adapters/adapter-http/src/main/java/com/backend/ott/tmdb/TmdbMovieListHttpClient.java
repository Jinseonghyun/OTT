package com.backend.ott.tmdb;

import com.backend.ott.client.TmdbHttpClient;
import com.backend.ott.movie.TmdbMovie;
import com.backend.ott.movie.TmdbMoviePort;
import com.backend.ott.movie.TmdbPageableMovies;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class TmdbMovieListHttpClient implements TmdbMoviePort {

    @Value("${tmdb.api.movie-lists.now-playing}")
    private String nowPlayingUrl;

    private final TmdbHttpClient tmdbHttpClient;

    @Override
    public TmdbPageableMovies fetchPageable(int page) {
        String url = nowPlayingUrl + "?language=ko-KR&page=" + page;
        String request = tmdbHttpClient.request(url, HttpMethod.GET, CollectionUtils.toMultiValueMap(Map.of()), Map.of());

        TmdbMovieNowPlayingResponse response;
        try {
            response = new ObjectMapper().readValue(request, TmdbMovieNowPlayingResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return new TmdbPageableMovies(
                response.getResults().stream()
                        .map(movie -> new TmdbMovie(
                                movie.getTitle(),
                                movie.getAdult(),
                                movie.getGenreIds(),
                                movie.getOverview(),
                                movie.getReleaseDate())).toList(),
                page,
                response.getTotalPages() - page != 0 // 조회 하고자 하는 페이지 0 이면 다음 페이지가 없다.
        );
    }
}
