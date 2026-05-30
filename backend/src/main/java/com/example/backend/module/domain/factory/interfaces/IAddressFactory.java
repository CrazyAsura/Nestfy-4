package com.example.backend.module.domain.factory.interfaces;

import com.example.backend.module.domain.models.Address;
import com.example.backend.module.domain.models.User;

public interface IAddressFactory {
    Address createAddress(Long id, String street, String number, String complement, String neighborhood, String city, String state, String zipCode, String country, User user);
}
