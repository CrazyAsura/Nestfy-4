package com.example.backend.module.infrastructure.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.backend.module.domain.ports.out.EventPublisherPortOut;
import com.example.backend.module.infrastructure.config.KafkaConfig;

@Component
public class EventPublisherImpl implements EventPublisherPortOut {
    private final KafkaConfig kafkaConfig;

    public EventPublisherImpl(KafkaConfig kafkaConfig) {
        this.kafkaConfig = kafkaConfig;
    }

    @Override
    public void publish(Object event) {
        kafkaConfig.sen(event);
    }
}
