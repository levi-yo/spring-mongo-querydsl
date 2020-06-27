package com.levi.querydsl;

import com.google.common.collect.Lists;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.connection.ClusterSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import javax.annotation.PostConstruct;
import java.io.IOException;

@TestConfiguration
public class TestEmbeddedMongoConfig {

    private final String ip = "127.0.0.1";
    private int port;

    @PostConstruct
    public void setup(){
        try {
            port = Network.getFreeServerPort();
        } catch (IOException e) {
            port = 27017;
        }
    }

    @EnableReactiveMongoRepositories(basePackages = {"com.levi.querydsl.repositories"}, reactiveMongoTemplateRef = "sampleEntityTemplate")
    @TestConfiguration
    static class EditMongoConfig {

    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public MongodExecutable mongodExecutable() throws IOException {

        MongodStarter starter = MongodStarter.getDefaultInstance();

        IMongodConfig mongodConfig = new MongodConfigBuilder()
                .version(Version.Main.V3_4)
                .net(new Net(ip, port, false))
                .build();

        MongodExecutable mongodExecutable = null;

        mongodExecutable = starter.prepare(mongodConfig);

        return mongodExecutable;
    }

    @Bean("sampleEntityTemplate")
    public ReactiveMongoTemplate mongoTemplate() {
        final ServerAddress serverAddress = new ServerAddress(ip, port);

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyToClusterSettings(sa -> sa.applySettings(getClusterSettings(serverAddress)))
                .build();

        MongoClient mongo = MongoClients.create(settings);

        return new ReactiveMongoTemplate(mongo, "querydsl");
    }

    private ClusterSettings getClusterSettings(ServerAddress serverAddress) {
        final ClusterSettings.Builder builder = ClusterSettings.builder();
        builder.hosts(Lists.newArrayList(serverAddress));

        return builder.build();
    }
}
