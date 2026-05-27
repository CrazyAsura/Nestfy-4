package com.example.backend.module.domain.models.interfaces;

import com.example.backend.module.domain.models.*;

public abstract class ITypeAddress {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract TypeAddressEnum getType();
    public abstract void setType(TypeAddressEnum type);

    public abstract Address getAddress();
    public abstract void setAddress(Address address);
}