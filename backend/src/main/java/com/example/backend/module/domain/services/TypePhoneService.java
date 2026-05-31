package com.example.backend.module.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.module.adapter.out.persistence.adapters.TypePhonePersistenceAdapter;
import com.example.backend.module.domain.models.TypePhone;
import com.example.backend.module.domain.models.TypePhoneEnum;
import com.example.backend.module.domain.models.User;

@Service
public class TypePhoneService {

    private final TypePhonePersistenceAdapter typePhonePersistenceAdapter;

    @Autowired
    public TypePhoneService(TypePhonePersistenceAdapter typePhonePersistenceAdapter) {
        this.typePhonePersistenceAdapter = typePhonePersistenceAdapter;
    }

    public TypePhone createTypePhone(TypePhone typePhone) {
        if (typePhone == null) {
            throw new IllegalArgumentException("TypePhone cannot be null");
        }
        return typePhonePersistenceAdapter.save(typePhone);
    }

    public TypePhone getTypePhone(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return typePhonePersistenceAdapter.findById(id).orElse(null);
    }

    public TypePhone updateTypePhone(TypePhone typePhone) {
        if (typePhone == null) {
            throw new IllegalArgumentException("TypePhone cannot be null");
        }
        return typePhonePersistenceAdapter.save(typePhone);
    }

    public void deleteTypePhone(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        typePhonePersistenceAdapter.deleteById(id);
    }

    public List<TypePhone> findByType(TypePhoneEnum type) {
        if (type == null) {
            throw new IllegalArgumentException("type cannot be null");
        }
        return typePhonePersistenceAdapter.findByType(type);
    }

    public List<TypePhone> findByUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("user cannot be null");
        }
        return typePhonePersistenceAdapter.findByUser(user);
    }
}
