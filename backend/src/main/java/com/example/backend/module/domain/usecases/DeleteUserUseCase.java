package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.ports.in.DeleteUserUseCasePortIn;
import com.example.backend.module.domain.ports.out.IUserRepositoryPortOut;

@Component
public class DeleteUserUseCase implements DeleteUserUseCasePortIn {
    private final IUserRepositoryPortOut userRepositoryPortOut;

    public DeleteUserUseCase(IUserRepositoryPortOut userRepositoryPortOut) {
        this.userRepositoryPortOut = userRepositoryPortOut;
    }

    @Override
    public void execute(Long id) {
        userRepositoryPortOut.deleteById(id);
    }
}

