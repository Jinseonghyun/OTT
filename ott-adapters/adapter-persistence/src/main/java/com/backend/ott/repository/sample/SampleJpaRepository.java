package com.backend.ott.repository.sample;

import com.backend.ott.entity.sample.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleJpaRepository extends JpaRepository<SampleEntity, String>, SampleCustomRepository {
}
