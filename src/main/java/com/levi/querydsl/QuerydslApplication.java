package com.levi.querydsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoReactiveDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoReactiveAutoConfiguration;

@SpringBootApplication(exclude = {
        MongoAutoConfiguration.class,
        MongoReactiveAutoConfiguration.class,
        MongoReactiveDataAutoConfiguration.class
})
public class QuerydslApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuerydslApplication.class, args);
    }

}
