package com.example.backend.module.infrastructure.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class KafkaConfig {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public KafkaConfig(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void send(Object event) {
        try {
            String message = objectMapper.writeValueAsString(event);
            kafkaTemplate.send("nestfy-events", message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize event to JSON String", e);
        }
    }
}
