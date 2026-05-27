package com.example.backend.module.domain.models;

import com.example.backend.module.domain.models.interfaces.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client extends IClient{

    private Long id;
    private User user;
    private TypeUser type;
    private Boolean active;
    
    public Client(Long id, User user, TypeUser type, Boolean active) {
        this.id = id;
        this.user = user;
        this.type = type;
        this.active = active;
    }

    public Client() {
    }
}