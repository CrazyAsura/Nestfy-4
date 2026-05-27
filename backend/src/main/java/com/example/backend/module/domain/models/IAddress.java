package com.example.backend.module.domain.models;

public interface IAddress {
    Long getId();
    void setId(Long id);

    String getStreet();
    void setStreet(String street);

    String getNumber();
    void setNumber(String number);

    String getComplement();
    void setComplement(String complement);

    String getNeighborhood();
    void setNeighborhood(String neighborhood);

    String getCity();
    void setCity(String city);

    String getState();
    void setState(String state);

    String getZipCode();
    void setZipCode(String zipCode);

    String getCountry();
    void setCountry(String country);

    User getUser();
    void setUser(User user);
}
