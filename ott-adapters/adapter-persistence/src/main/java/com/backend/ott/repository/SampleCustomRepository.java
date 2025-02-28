package com.backend.ott.repository;

import com.backend.ott.entity.SampleEntity;

import java.util.List;

public interface SampleCustomRepository {
    List<SampleEntity> findAllByAbc();
}
