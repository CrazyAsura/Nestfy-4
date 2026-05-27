package com.example.backend.module.adapter.out.persistence.entities.interfaces;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class IMoneyEntity {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract String getName();
    public abstract void setName(String name);

    public abstract String getSymbol();
    public abstract void setSymbol(String symbol);

    public abstract Boolean getActive();
    public abstract void setActive(Boolean active);
}
