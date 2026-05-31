package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.adapter.out.persistence.repositories.*;

@Component
public class PhoneDatabaseAdapter implements IPhoneRepositoryPortOut {

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public Phone save(Phone entity) {
        return phoneRepository.save(entity);
    }

    @Override
    public Optional<Phone> findById(Long id) {
        return phoneRepository.findById(id);
    }

    @Override
    public Iterable<Phone> findAll() {
        return phoneRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        phoneRepository.deleteById(id);
    }

    @Override
    public Optional<Phone> findByNumber(String number) {
        return phoneRepository.findByNumber(number).stream().findFirst();
    }

    @Override
    public List<Phone> findByUserId(Long userId) {
        return phoneRepository.findByUserId(userId);
    }
}
