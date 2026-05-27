package com.example.backend.module.domain.models.interfaces;

import com.example.backend.module.domain.models.*;


public abstract class ISuperAdmin {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract User getUser();
    public abstract void setUser(User user);

    public abstract TypeUser getType();
    public abstract void setType(TypeUser type);

    public abstract Boolean getActive();
    public abstract void setActive(Boolean active);
}