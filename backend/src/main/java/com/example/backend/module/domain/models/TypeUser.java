package com.example.backend.module.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypeUser implements ITypeUser {

    private Long id;
    private TypeUserEnum type;
    private User user;

    public TypeUser() {
    }
    
    public TypeUser(Long id, TypeUserEnum type, User user) {
        this.id = id;
        this.type = type;
        this.user = user;
    }
}