package com.example.backend.module.domain.ports.out;

import java.util.List;

import com.example.backend.module.domain.models.Address;

public interface IAddressRepositoryPortOut extends IRepositoryPortOut<Address, Long> {

    public List<Address> findByUserId(Long userId);
    
    public List<Address> findByActive(Boolean active);

}
