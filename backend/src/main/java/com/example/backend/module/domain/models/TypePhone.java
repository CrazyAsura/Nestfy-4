package com.example.backend.module.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypePhone implements ITypePhone {
    private Long id;
    private TypePhoneEnum type;
    private User user;

    public TypePhone() {
    }
    
    public TypePhone(Long id, TypePhoneEnum type, User user) {
        this.id = id;
        this.type = type;
        this.user = user;
    }
}
