package com.example.backend.module.adapter.out.persistence.entities.interfaces;

import lombok.Getter;
import lombok.Setter;
import com.example.backend.module.domain.models.TypePhoneEnum;
import com.example.backend.module.adapter.out.persistence.entities.*;

@Getter
@Setter
public abstract class ITypePhoneEntity {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract TypePhoneEnum getType();
    public abstract void setType(TypePhoneEnum type);

    public abstract UserEntity getUser();
    public abstract void setUser(UserEntity user);
}
