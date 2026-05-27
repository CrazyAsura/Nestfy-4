package com.example.backend.module.domain.models.interfaces;

import com.example.backend.module.domain.models.*;

public abstract class ITypePhone {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract TypePhoneEnum getType();
    public abstract void setType(TypePhoneEnum type);

    public abstract User getUser();
    public abstract void setUser(User user);
}