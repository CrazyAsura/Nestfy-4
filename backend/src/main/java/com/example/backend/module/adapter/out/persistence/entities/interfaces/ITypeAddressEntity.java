package com.example.backend.module.adapter.out.persistence.entities.interfaces;

import lombok.Getter;
import lombok.Setter;
import com.example.backend.module.domain.models.TypeAddressEnum;
import com.example.backend.module.adapter.out.persistence.entities.*;

@Getter
@Setter
public abstract class ITypeAddressEntity {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract TypeAddressEnum getType();
    public abstract void setType(TypeAddressEnum type);

    public abstract AddressEntity getAddress();
    public abstract void setAddress(AddressEntity address);
}
