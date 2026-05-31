package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.User;
import com.example.backend.module.domain.ports.out.IUserRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateUserUseCase;
import com.example.backend.module.domain.usecases.DeleteUserUseCase;
import com.example.backend.module.domain.usecases.GetUserUseCase;
import com.example.backend.module.domain.usecases.UpdateUserUseCase;

@Component
public class UserPersistenceAdapter {

    private final CreateUserUseCase createUserUseCase;
    private final GetUserUseCase getUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final IUserRepositoryPortOut userRepositoryPortOut;

    @Autowired
    public UserPersistenceAdapter(CreateUserUseCase createUserUseCase,
            GetUserUseCase getUserUseCase,
            UpdateUserUseCase updateUserUseCase,
            DeleteUserUseCase deleteUserUseCase,
            IUserRepositoryPortOut userRepositoryPortOut) {
        this.createUserUseCase = createUserUseCase;
        this.getUserUseCase = getUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
        this.userRepositoryPortOut = userRepositoryPortOut;
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(getUserUseCase.execute(id));
    }

    public Iterable<User> findAll() {
        return userRepositoryPortOut.findAll();
    }

    public User save(User entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (entity.getId() == null) {
            return createUserUseCase.execute(entity);
        } else {
            return updateUserUseCase.execute(entity);
        }
    }

    public void deleteById(Long id) {
        deleteUserUseCase.execute(id);
    }

    public Optional<User> findByEmail(String email) {
        return userRepositoryPortOut.findByEmail(email);
    }

    public Optional<User> findByCpf(String cpf) {
        return userRepositoryPortOut.findByCpf(cpf);
    }

    public Optional<User> findByCnpj(String cnpj) {
        return userRepositoryPortOut.findByCnpj(cnpj);
    }

    public List<User> findByType(String type) {
        return userRepositoryPortOut.findByType(type);
    }

    public List<User> findByActive(Boolean active) {
        return userRepositoryPortOut.findByActive(active);
    }
}
