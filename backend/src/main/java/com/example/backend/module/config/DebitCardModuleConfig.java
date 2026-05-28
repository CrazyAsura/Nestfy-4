package com.example.backend.module.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "com.example.backend.module", excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,
        pattern = "com\\.example\\.backend\\.module\\.domain\\.services\\..*" + "|com\\.example\\.backend\\.module\\.infrastructure\\.persistence\\..*" + "|com\\.example\\.backend\\.module\\.infrastructure\\.exception\\..*"))
public class DebitCardModuleConfig {
}