package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.CartItem;
import com.example.backend.module.domain.ports.in.UpdateCartItemUseCasePortIn;
import com.example.backend.module.domain.ports.out.ICartItemRepositoryPortOut;

public class UpdateCartItemUseCase implements UpdateCartItemUseCasePortIn {
    private final ICartItemRepositoryPortOut cartItemRepositoryPortOut;

    public UpdateCartItemUseCase(ICartItemRepositoryPortOut cartItemRepositoryPortOut) {
        this.cartItemRepositoryPortOut = cartItemRepositoryPortOut;
    }

    @Override
    public CartItem execute(CartItem cartItem) {
        return cartItemRepositoryPortOut.save(cartItem);
    }
}

