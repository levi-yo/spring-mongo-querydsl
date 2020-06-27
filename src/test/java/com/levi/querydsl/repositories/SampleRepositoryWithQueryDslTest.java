package com.levi.querydsl.repositories;

import com.levi.querydsl.TestEmbeddedMongoConfig;
import com.levi.querydsl.entity.SampleEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static com.levi.querydsl.entity.SampleEntity.Job.BACK_END;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnabledOnOs(OS.MAC)
@Nested
@ContextConfiguration(
        initializers = ConfigFileApplicationContextInitializer.class,
        classes = {
                TestEmbeddedMongoConfig.class,
                SampleRepository.class,
                SampleRepositoryWithQueryDsl.class
        })
@ExtendWith(SpringExtension.class)
public class SampleRepositoryWithQueryDslTest {
    @Autowired
    private SampleRepositoryWithQueryDsl sampleRepositoryWithQueryDsl;
    @Autowired
    private SampleRepository sampleRepository;

    @BeforeEach
    public void initData() {
        SampleEntity sampleEntity = new SampleEntity();
        sampleEntity.setName("levi");
        sampleEntity.setAge(29);
        sampleEntity.setJob(BACK_END);

        sampleRepository.save(sampleEntity).block();
    }

    @Test
    @DisplayName("이름으로 조회")
    void findByName() {
        //준비
        final String name = "levi";

        //실행
        List<SampleEntity> results = sampleRepositoryWithQueryDsl.findByName(name).collectList().block();

        //단언
        assertNotNull(results);
        assertEquals(1, results.size());
        assertEquals("levi", results.get(0).getName());
        assertEquals(BACK_END, results.get(0).getJob());

        System.out.println("[result] : \n" + Arrays.toString(results.toArray()));
    }
}
