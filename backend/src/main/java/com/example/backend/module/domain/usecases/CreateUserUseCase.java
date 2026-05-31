package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.User;
import com.example.backend.module.domain.ports.in.CreateUserUseCasePortIn;
import com.example.backend.module.domain.ports.out.IUserRepositoryPortOut;

@Component
public class CreateUserUseCase implements CreateUserUseCasePortIn {
    private final IUserRepositoryPortOut userRepositoryPortOut;

    public CreateUserUseCase(IUserRepositoryPortOut userRepositoryPortOut) {
        this.userRepositoryPortOut = userRepositoryPortOut;
    }

    @Override
    public User execute(User user) {
        return userRepositoryPortOut.save(user);
    }
}

