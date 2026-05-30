package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.User;
import com.example.backend.module.domain.ports.in.UpdateUserUseCasePortIn;
import com.example.backend.module.domain.ports.out.IUserRepositoryPortOut;

public class UpdateUserUseCase implements UpdateUserUseCasePortIn {
    private final IUserRepositoryPortOut userRepositoryPortOut;

    public UpdateUserUseCase(IUserRepositoryPortOut userRepositoryPortOut) {
        this.userRepositoryPortOut = userRepositoryPortOut;
    }

    @Override
    public User execute(User user) {
        return userRepositoryPortOut.save(user);
    }
}

