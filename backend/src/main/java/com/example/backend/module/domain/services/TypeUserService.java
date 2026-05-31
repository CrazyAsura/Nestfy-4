package com.example.backend.module.domain.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.module.adapter.out.persistence.adapters.TypeUserPersistenceAdapter;
import com.example.backend.module.domain.models.TypeUser;
import com.example.backend.module.domain.models.TypeUserEnum;
import com.example.backend.module.domain.models.User;

@Service
public class TypeUserService {

    private final TypeUserPersistenceAdapter typeUserPersistenceAdapter;

    @Autowired
    public TypeUserService(TypeUserPersistenceAdapter typeUserPersistenceAdapter) {
        this.typeUserPersistenceAdapter = typeUserPersistenceAdapter;
    }

    public TypeUser createTypeUser(TypeUser typeUser) {
        if (typeUser == null) {
            throw new IllegalArgumentException("TypeUser cannot be null");
        }
        return typeUserPersistenceAdapter.save(typeUser);
    }

    public TypeUser getTypeUser(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return typeUserPersistenceAdapter.findById(id).orElse(null);
    }

    public TypeUser updateTypeUser(TypeUser typeUser) {
        if (typeUser == null) {
            throw new IllegalArgumentException("TypeUser cannot be null");
        }
        return typeUserPersistenceAdapter.save(typeUser);
    }

    public void deleteTypeUser(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        typeUserPersistenceAdapter.deleteById(id);
    }

    public List<TypeUser> findByType(TypeUserEnum type) {
        if (type == null) {
            throw new IllegalArgumentException("type cannot be null");
        }
        return typeUserPersistenceAdapter.findByType(type);
    }

    public List<TypeUser> findByUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("user cannot be null");
        }
        return typeUserPersistenceAdapter.findByUser(user);
    }
}
