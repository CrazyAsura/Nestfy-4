package com.example.backend.module.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypeAddress implements ITypeAddress {

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