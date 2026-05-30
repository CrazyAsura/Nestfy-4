package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.Cart;
import com.example.backend.module.domain.ports.in.UpdateCartUseCasePortIn;
import com.example.backend.module.domain.ports.out.ICartRepositoryPortOut;

public class UpdateCartUseCase implements UpdateCartUseCasePortIn {
    private final ICartRepositoryPortOut cartRepositoryPortOut;

    public UpdateCartUseCase(ICartRepositoryPortOut cartRepositoryPortOut) {
        this.cartRepositoryPortOut = cartRepositoryPortOut;
    }

    @Override
    public Cart execute(Cart cart) {
        return cartRepositoryPortOut.save(cart);
    }
}

