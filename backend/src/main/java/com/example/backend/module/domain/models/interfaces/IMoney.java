package com.example.backend.module.domain.models.interfaces;


public abstract class IMoney {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract String getName();
    public abstract void setName(String name);

    public abstract String getSymbol();
    public abstract void setSymbol(String symbol);

    public abstract Boolean getActive();
    public abstract void setActive(Boolean active);
}