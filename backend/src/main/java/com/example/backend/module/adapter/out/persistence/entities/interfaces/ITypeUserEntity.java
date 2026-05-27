package com.example.backend.module.adapter.out.persistence.entities.interfaces;

import lombok.Getter;
import lombok.Setter;
import com.example.backend.module.domain.models.TypeUserEnum;
import com.example.backend.module.adapter.out.persistence.entities.*;

@Getter
@Setter
public abstract class ITypeUserEntity {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract TypeUserEnum getType();
    public abstract void setType(TypeUserEnum type);

    public abstract UserEntity getUser();
    public abstract void setUser(UserEntity user);
}
