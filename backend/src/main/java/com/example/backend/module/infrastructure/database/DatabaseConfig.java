package com.example.backend.module.infrastructure.database;

import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatabaseConfig {
    @Value("${db.postgres.url}")
    private String dbPostgresUrl;

    @Value("${db.postgres.username}")
    private String dbPostgresUsername;

    @Value("${db.postgres.password}")
    private String dbPostgresPassword;

    @Value("${db.postgres.driver-class-name}")
    private String dbPostgresDriverClassName;

    @Value("${db.mongodb.url}")
    private String dbMongodbUrl;

    @Value("${db.mongodb.database}")
    private String dbMongodbDatabase;

}
