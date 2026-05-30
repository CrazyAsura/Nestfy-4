package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.ports.in.DeleteUserUseCasePortIn;
import com.example.backend.module.domain.ports.out.IUserRepositoryPortOut;

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

