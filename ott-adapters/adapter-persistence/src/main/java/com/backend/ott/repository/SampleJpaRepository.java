package com.backend.ott.repository;

import com.backend.ott.entity.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleJpaRepository extends JpaRepository<SampleEntity, String>, SampleCustomRepository {
}
