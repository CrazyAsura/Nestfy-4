package com.example.backend.module.domain.models;

public interface IMoney {
    Long getId();
    void setId(Long id);

    String getName();
    void setName(String name);

    String getSymbol();
    void setSymbol(String symbol);

    Boolean getActive();
    void setActive(Boolean active);
}
