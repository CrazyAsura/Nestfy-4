package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.adapter.out.persistence.repositories.UserRepository;
import com.example.backend.module.domain.models.User;
import com.example.backend.module.domain.ports.out.IUserRepositoryPortOut;

@Component
public class UserDatabaseAdapter implements IUserRepositoryPortOut {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email).stream().findFirst();
    }

    @Override
    public Optional<User> findByCpf(String cpf) {
        return userRepository.findByCpf(cpf).stream().findFirst();
    }

    @Override
    public Optional<User> findByCnpj(String cnpj) {
        return userRepository.findByCnpj(cnpj).stream().findFirst();
    }

    @Override
    public List<User> findByType(String type) {
        return userRepository.findAll().stream()
                .filter(u -> u.getType() != null && u.getType().getType() != null && u.getType().getType().name().equalsIgnoreCase(type))
                .toList();
    }

    @Override
    public List<User> findByActive(Boolean active) {
        return userRepository.findByActive(active);
    }
}
