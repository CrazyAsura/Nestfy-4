package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.ports.in.DeleteCartUseCasePortIn;
import com.example.backend.module.domain.ports.out.ICartRepositoryPortOut;

@Component
public class DeleteCartUseCase implements DeleteCartUseCasePortIn {
    private final ICartRepositoryPortOut cartRepositoryPortOut;

    public DeleteCartUseCase(ICartRepositoryPortOut cartRepositoryPortOut) {
        this.cartRepositoryPortOut = cartRepositoryPortOut;
    }

    @Override
    public void execute(Long id) {
        cartRepositoryPortOut.deleteById(id);
    }
}

