package com.example.backend.module.domain.models.interfaces;

import com.example.backend.module.domain.models.*;

public abstract class ITypeUser {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract TypeUserEnum getType();
    public abstract void setType(TypeUserEnum type);

    public abstract User getUser();
    public abstract void setUser(User user);
}