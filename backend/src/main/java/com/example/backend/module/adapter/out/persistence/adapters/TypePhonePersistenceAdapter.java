package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.adapter.out.persistence.repositories.TypePhoneRepository;
import com.example.backend.module.domain.models.TypePhone;
import com.example.backend.module.domain.models.TypePhoneEnum;
import com.example.backend.module.domain.models.User;
import com.example.backend.module.domain.ports.out.ITypePhoneRepositoryPortOut;

@Component
public class TypePhonePersistenceAdapter implements ITypePhoneRepositoryPortOut {

    @Autowired
    private TypePhoneRepository typePhoneRepository;

    @Override
    public TypePhone save(TypePhone typePhone) {
        return typePhoneRepository.save(typePhone);
    }

    @Override
    public Optional<TypePhone> findById(Long id) {
        return typePhoneRepository.findById(id);
    }

    @Override
    public Iterable<TypePhone> findAll() {
        return typePhoneRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        typePhoneRepository.deleteById(id);
    }

    @Override
    public List<TypePhone> findByType(TypePhoneEnum type) {
        return typePhoneRepository.findByType(type);
    }

    @Override
    public List<TypePhone> findByUser(User user) {
        return typePhoneRepository.findByUser(user);
    }
}

