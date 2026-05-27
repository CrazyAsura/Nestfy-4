package com.example.backend.module.domain.ports.out;

import java.util.List;
import java.util.Optional;

import com.example.backend.module.domain.models.Phone;

public interface PhoneRepositoryPortOut extends IRepositoryPortOut<Phone, Long> {

    public Optional<Phone> findByNumber(String number);
    public List<Phone> findByUserId(Long userId);

}