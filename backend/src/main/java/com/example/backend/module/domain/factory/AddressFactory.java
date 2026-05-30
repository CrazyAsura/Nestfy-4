package com.example.backend.module.domain.factory;

import com.example.backend.module.domain.models.Address;
import com.example.backend.module.domain.models.User;
import com.example.backend.module.domain.factory.interfaces.IAddressFactory;
import org.springframework.stereotype.Component;

@Component
public class AddressFactory implements IAddressFactory {

    @Override
    public Address createAddress(Long id, String street, String number, String complement, String neighborhood, String city, String state, String zipCode, String country, User user) {
        return new Address(id, street, number, complement, neighborhood, city, state, zipCode, country, user);
    }
}
