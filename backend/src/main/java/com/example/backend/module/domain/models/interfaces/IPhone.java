package com.example.backend.module.domain.models.interfaces;

import com.example.backend.module.domain.models.*;


public abstract class IPhone {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract String getDdi();
    public abstract void setDdi(String ddi);

    public abstract String getDdd();
    public abstract void setDdd(String ddd);

    public abstract String getNumber();
    public abstract void setNumber(String number);

    public abstract TypePhone getType();
    public abstract void setType(TypePhone type);

    public abstract User getUser();
    public abstract void setUser(User user);
}