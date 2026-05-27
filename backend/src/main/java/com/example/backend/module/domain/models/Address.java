package com.example.backend.module.domain.models;

import com.example.backend.module.domain.models.interfaces.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address extends IAddress{

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
    
    public Address() {
    }
    
    public Address(Long id, String street, String number, String complement, String neighborhood, String city, String state, String zipCode, String country, User user) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.user = user;
    }

}