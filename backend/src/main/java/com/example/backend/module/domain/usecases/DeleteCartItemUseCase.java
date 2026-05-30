package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.ports.in.DeleteCartItemUseCasePortIn;
import com.example.backend.module.domain.ports.out.ICartItemRepositoryPortOut;

public class DeleteCartItemUseCase implements DeleteCartItemUseCasePortIn {
    private final ICartItemRepositoryPortOut cartItemRepositoryPortOut;

    public DeleteCartItemUseCase(ICartItemRepositoryPortOut cartItemRepositoryPortOut) {
        this.cartItemRepositoryPortOut = cartItemRepositoryPortOut;
    }

    @Override
    public void execute(Long id) {
        cartItemRepositoryPortOut.deleteById(id);
    }
}

