package com.example.backend.module.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Money implements IMoney {

    private Long id;
    private String name;
    private String symbol;
    private Boolean active;
    
    public Money(Long id, String name, String symbol, Boolean active) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.active = active;
    }

    public Money() {
    }
}