package com.example.backend.module.infrastructure.messaging;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.ports.out.IEventPublisherPortOut;

@Component
public class EventPublisherImpl implements IEventPublisherPortOut {
    private final KafkaConfig kafkaConfig;

    public EventPublisherImpl(KafkaConfig kafkaConfig) {
        this.kafkaConfig = kafkaConfig;
    }

    @Override
    public void publish(Object event) {
        kafkaConfig.send(event);
    }
}

