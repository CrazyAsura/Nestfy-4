package com.example.backend.module.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Phone implements IPhone {
    
    private Long id;
    private String ddi;
    private String ddd;
    private String number;
    private TypePhone type;
    private User user;
    
    public Phone() {
    }
    
    public Phone(Long id, String ddi, String ddd, String number, TypePhone type, User user) {
        this.id = id;   
        this.ddi = ddi;
        this.ddd = ddd;
        this.number = number;
        this.type = type;
        this.user = user;
    }

}