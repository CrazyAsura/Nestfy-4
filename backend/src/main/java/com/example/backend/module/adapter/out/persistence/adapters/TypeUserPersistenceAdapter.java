package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.adapter.out.persistence.repositories.TypeUserRepository;
import com.example.backend.module.domain.models.TypeUser;
import com.example.backend.module.domain.models.TypeUserEnum;
import com.example.backend.module.domain.models.User;
import com.example.backend.module.domain.ports.out.ITypeUserRepositoryPortOut;

@Component
public class TypeUserPersistenceAdapter implements ITypeUserRepositoryPortOut {

    @Autowired
    private TypeUserRepository typeUserRepository;

    @Override
    public TypeUser save(TypeUser typeUser) {
        return typeUserRepository.save(typeUser);
    }

    @Override
    public Optional<TypeUser> findById(Long id) {
        return typeUserRepository.findById(id);
    }

    @Override
    public Iterable<TypeUser> findAll() {
        return typeUserRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        typeUserRepository.deleteById(id);
    }

    @Override
    public List<TypeUser> findByType(TypeUserEnum type) {
        return typeUserRepository.findByType(type);
    }

    @Override
    public List<TypeUser> findByUser(User user) {
        return typeUserRepository.findByUser(user);
    }
}

