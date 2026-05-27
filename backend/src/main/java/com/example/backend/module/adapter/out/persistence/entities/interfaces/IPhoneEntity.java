package com.example.backend.module.adapter.out.persistence.entities.interfaces;

import lombok.Getter;
import lombok.Setter;
import com.example.backend.module.adapter.out.persistence.entities.*;

@Getter
@Setter
public abstract class IPhoneEntity {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract String getDdi();
    public abstract void setDdi(String ddi);

    public abstract String getDdd();
    public abstract void setDdd(String ddd);

    public abstract String getNumber();
    public abstract void setNumber(String number);

    public abstract TypePhoneEntity getType();
    public abstract void setType(TypePhoneEntity type);

    public abstract UserEntity getUser();
    public abstract void setUser(UserEntity user);
}
