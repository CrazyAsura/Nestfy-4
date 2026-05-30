package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.Address;

public interface CreateAddressUseCasePortIn {
    Address execute(Address address);   
}
