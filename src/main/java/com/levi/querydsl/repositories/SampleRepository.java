package com.levi.querydsl.repositories;

import com.levi.querydsl.entity.SampleEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.querydsl.ReactiveQuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

public interface SampleRepository extends ReactiveMongoRepository<SampleEntity, String>, ReactiveQuerydslPredicateExecutor<SampleEntity> {
}
