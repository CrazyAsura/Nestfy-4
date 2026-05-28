package com.example.backend.module.infrastructure.monitoring;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TelemetryConfig {
    @Bean
    public MeterRegistry meterRegistry() {
        PrometheusMeterRegistry meterRegistry = new PrometheusMeterRegistry();
        meterRegistry.config().meterFilter(
                new PrometheusTextFormat.CollectorRegistryCollector(
                        meterRegistry.getPrometheusRegistry()));
        return meterRegistry;
    }
}
