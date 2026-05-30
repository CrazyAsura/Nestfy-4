package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.User;
import com.example.backend.module.domain.ports.in.GetUserUseCasePortIn;
import com.example.backend.module.domain.ports.out.IUserRepositoryPortOut;

public class GetUserUseCase implements GetUserUseCasePortIn {
    private final IUserRepositoryPortOut iUserRepositoryPortOut;

    public GetUserUseCase(IUserRepositoryPortOut iUserRepositoryPortOut) {
        this.iUserRepositoryPortOut = iUserRepositoryPortOut;
    }

    @Override
    public User execute(Long id) {
        return iUserRepositoryPortOut.findById(id).orElse(null);
    }
}

