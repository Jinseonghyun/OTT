package com.backend.ott.repository.sample;

import com.backend.ott.entity.sample.SampleEntity;

import java.util.List;

public interface SampleCustomRepository {
    List<SampleEntity> findAllByAbc();
}
