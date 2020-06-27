package com.levi.querydsl.repositories;

import com.levi.querydsl.entity.QSampleEntity;
import com.levi.querydsl.entity.SampleEntity;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
@RequiredArgsConstructor
public class SampleRepositoryWithQueryDsl {
    private final SampleRepository sampleRepository;

    public Flux<SampleEntity> findByName(final String name) {
        QSampleEntity qSampleEntity = QSampleEntity.sampleEntity;
        Predicate predicate = qSampleEntity.name.eq(name);
        return sampleRepository.findAll(predicate);
    }
}
