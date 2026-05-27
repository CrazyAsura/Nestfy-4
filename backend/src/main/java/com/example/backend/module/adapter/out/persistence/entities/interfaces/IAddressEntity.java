package com.example.backend.module.adapter.out.persistence.entities.interfaces;

import lombok.Getter;
import lombok.Setter;
import com.example.backend.module.adapter.out.persistence.entities.*;

@Getter
@Setter
public abstract class IAddressEntity {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract String getStreet();
    public abstract void setStreet(String street);

    public abstract String getNumber();
    public abstract void setNumber(String number);

    public abstract String getComplement();
    public abstract void setComplement(String complement);

    public abstract String getNeighborhood();
    public abstract void setNeighborhood(String neighborhood);

    public abstract String getCity();
    public abstract void setCity(String city);

    public abstract String getState();
    public abstract void setState(String state);

    public abstract String getZipCode();
    public abstract void setZipCode(String zipCode);

    public abstract String getCountry();
    public abstract void setCountry(String country);

    public abstract UserEntity getUser();
    public abstract void setUser(UserEntity user);
}
