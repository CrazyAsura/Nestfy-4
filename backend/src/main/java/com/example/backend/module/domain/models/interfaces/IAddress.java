package com.example.backend.module.domain.models.interfaces;

import com.example.backend.module.domain.models.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class IAddress {

    private Long id;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private User user;
}