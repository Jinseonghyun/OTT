package com.backend.ott.repository.sample;

import com.backend.ott.entity.QSampleEntity;
import com.backend.ott.entity.sample.SampleEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SampleCustomRepositoryImpl implements SampleCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<SampleEntity> findAllByAbc() {
        return jpaQueryFactory.selectFrom(QSampleEntity.sampleEntity)
                .fetch();
    }
}
