package com.levi.querydsl.repositories;

import com.levi.querydsl.entity.SampleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class SampleRepositoryImpl {
    private final SampleRepository sampleRepository;

    public Mono<SampleEntity> findById(final String id) {
        return sampleRepository.findById(id);
    }

    public Mono<Integer> countGroupByJob(final SampleEntity.Job job) {

    }
}
