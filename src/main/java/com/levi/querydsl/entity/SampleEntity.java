package com.levi.querydsl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class SampleEntity {
    @Id
    private String id;
    private String name;
    private int age;
    private Job job;
    private Address address;

    public enum Job {
        PROGRAMMER, DESIGNER, FRONT_END;
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    @NoArgsConstructor
    public static class Address {
        private String si;
        private String gu;
        private String dong;
    }
}
