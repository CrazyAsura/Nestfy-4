package com.example.backend.module.domain.factory;

import com.example.backend.module.domain.models.Address;
import com.example.backend.module.domain.models.User;

public class AddressFactory {

    public static Address createAddress(Long id, String street, String number, String neighborhood, String city, String state, String zipCode, String complement, User user) {
        Address address = new Address();
        address.setId(id);
        address.setStreet(street);
        address.setNumber(number);
        address.setNeighborhood(neighborhood);
        address.setCity(city);
        address.setState(state);
        address.setZipCode(zipCode);
        address.setComplement(complement);
        address.setUser(user);
        return address;
    }
}
