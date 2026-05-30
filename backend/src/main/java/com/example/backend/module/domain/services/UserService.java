package com.example.backend.module.domain.services;

import com.example.backend.module.domain.models.User;
import com.example.backend.module.domain.ports.out.IUserRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateUserUseCase;
import com.example.backend.module.domain.usecases.DeleteUserUseCase;
import com.example.backend.module.domain.usecases.GetUserUseCase;
import com.example.backend.module.domain.usecases.UpdateUserUseCase;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final CreateUserUseCase createUserUseCase;
    private final GetUserUseCase getUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

    public UserService(IUserRepositoryPortOut userRepositoryPortOut) {
        this.createUserUseCase = new CreateUserUseCase(userRepositoryPortOut);
        this.getUserUseCase = new GetUserUseCase(userRepositoryPortOut);
        this.updateUserUseCase = new UpdateUserUseCase(userRepositoryPortOut);
        this.deleteUserUseCase = new DeleteUserUseCase(userRepositoryPortOut);
    }

    public User createUser(User user) {
        return createUserUseCase.execute(user);
    }

    public User getUser(Long id) {
        return getUserUseCase.execute(id);
    }

    public User updateUser(User user) {
        return updateUserUseCase.execute(user);
    }

    public void deleteUser(Long id) {
        deleteUserUseCase.execute(id);
    }
}
