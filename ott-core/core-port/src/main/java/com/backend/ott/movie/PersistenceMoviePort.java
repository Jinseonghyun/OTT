package com.backend.ott.movie;

import java.util.List;

public interface PersistenceMoviePort {
    List<OttMovie> fetchBy(int page, int size);

    OttMovie findBy(String movieName);

    void insert(OttMovie ottMovie);
}
