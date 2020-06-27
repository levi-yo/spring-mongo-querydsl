package com.levi.querydsl.config;

import com.levi.querydsl.repositories.MongoRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(
        basePackageClasses = {MongoRepositories.class}
)
public class MongoConfig extends AbstractReactiveMongoConfiguration {
    @Value("${mongodb.database}")
    private String databaseName;
    
    @Override
    protected String getDatabaseName() {
        return databaseName;
    }
}
