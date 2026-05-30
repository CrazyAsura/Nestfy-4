package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.Address;

public interface GetAddressUseCasePortIn {
    Address execute(Long id);
}
