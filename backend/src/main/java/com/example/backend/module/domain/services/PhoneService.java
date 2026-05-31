package com.example.backend.module.domain.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.adapter.out.persistence.adapters.PhonePersistenceAdapter;

@Service
public class PhoneService {

    private final PhonePersistenceAdapter phonePersistenceAdapter;

    @Autowired
    public PhoneService(PhonePersistenceAdapter phonePersistenceAdapter) {
        this.phonePersistenceAdapter = phonePersistenceAdapter;
    }

    public Phone createPhone(Phone phone) {
        if (phone == null) {
            throw new IllegalArgumentException("Phone cannot be null");
        }
        return phonePersistenceAdapter.save(phone);
    }

    public Phone getPhone(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return phonePersistenceAdapter.findById(id).orElse(null);
    }

    public Phone updatePhone(Phone phone) {
        if (phone == null) {
            throw new IllegalArgumentException("Phone cannot be null");
        }
        return phonePersistenceAdapter.save(phone);
    }

    public void deletePhone(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        phonePersistenceAdapter.deleteById(id);
    }
    public Optional<Phone> findByNumber(String number) {
        if (number == null) {
            throw new IllegalArgumentException("number cannot be null");
        }
        return phonePersistenceAdapter.findByNumber(number);
    }

    public List<Phone> findByUserId(Long userId) {
        if (userId == null) {
            throw new IllegalArgumentException("userId cannot be null");
        }
        return phonePersistenceAdapter.findByUserId(userId);
    }
}
