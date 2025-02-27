package com.backend.ott.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class TmdbMovieNowPlaying {
    private Boolean adult;

    @JsonProperty("backdrop_path")// 언더바 형식으로 우리는 잘 사용안함, camel case 형식을 선호하기에 받아온 backdrop_path 값을 가지고 backdropPath 로 맵핑
    private String backdropPath;

    @JsonProperty("genre_ids")
    private List<String> genreIds; // 장르 id

    private Integer id;

    @JsonProperty("original_language")
    private String originalLanguage;

    @JsonProperty("original_title")
    private String originalTitle;

    private String overview;

    private String popularity;

    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("release_date")
    private String releaseDate;

    private String title;

    private String video;

    @JsonProperty("vote_average")
    private String voteAverage;

    @JsonProperty("vote_count")
    private String voteCount;

}
