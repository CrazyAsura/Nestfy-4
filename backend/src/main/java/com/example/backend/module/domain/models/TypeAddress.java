package com.example.backend.module.domain.models;

import com.example.backend.module.domain.models.interfaces.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypeAddress extends ITypeAddress{

    private Long id;
    private TypeAddressEnum type;
    private Address address;

    public TypeAddress(Long id, TypeAddressEnum type, Address address) {
        this.id = id;
        this.type = type;
        this.address = address;
    }

    public TypeAddress() {
    }
}