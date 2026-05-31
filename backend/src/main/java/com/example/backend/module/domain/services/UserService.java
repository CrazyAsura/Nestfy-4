package com.example.backend.module.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.module.adapter.out.persistence.adapters.UserPersistenceAdapter;
import com.example.backend.module.domain.models.User;

@Service
public class UserService {

    private final UserPersistenceAdapter userPersistenceAdapter;

    @Autowired
    public UserService(UserPersistenceAdapter userPersistenceAdapter) {
        this.userPersistenceAdapter = userPersistenceAdapter;
    }

    public User createUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        return userPersistenceAdapter.save(user);
    }

    public User getUser(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return userPersistenceAdapter.findById(id).orElse(null);
    }

    public User updateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        return userPersistenceAdapter.save(user);
    }

    public void deleteUser(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        userPersistenceAdapter.deleteById(id);
    }

    public Optional<User> findByEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("email cannot be null");
        }
        return userPersistenceAdapter.findByEmail(email);
    }

    public Optional<User> findByCpf(String cpf) {
        if (cpf == null) {
            throw new IllegalArgumentException("cpf cannot be null");
        }
        return userPersistenceAdapter.findByCpf(cpf);
    }

    public Optional<User> findByCnpj(String cnpj) {
        if (cnpj == null) {
            throw new IllegalArgumentException("cnpj cannot be null");
        }
        return userPersistenceAdapter.findByCnpj(cnpj);
    }

    public List<User> findByType(String type) {
        if (type == null) {
            throw new IllegalArgumentException("type cannot be null");
        }
        return userPersistenceAdapter.findByType(type);
    }

    public List<User> findByActive(Boolean active) {
        if (active == null) {
            throw new IllegalArgumentException("active cannot be null");
        }
        return userPersistenceAdapter.findByActive(active);
    }
}
