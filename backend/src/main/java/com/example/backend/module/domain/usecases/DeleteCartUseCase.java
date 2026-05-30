package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.ports.in.DeleteCartUseCasePortIn;
import com.example.backend.module.domain.ports.out.ICartRepositoryPortOut;

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

