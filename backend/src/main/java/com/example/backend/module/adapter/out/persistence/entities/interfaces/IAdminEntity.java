package com.example.backend.module.adapter.out.persistence.entities.interfaces;

import lombok.Getter;
import lombok.Setter;
import com.example.backend.module.adapter.out.persistence.entities.*;

@Getter
@Setter
public abstract class IAdminEntity {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract UserEntity getUser();
    public abstract void setUser(UserEntity user);

    public abstract TypeUserEntity getType();
    public abstract void setType(TypeUserEntity type);

    public abstract Boolean getActive();
    public abstract void setActive(Boolean active);
}
