package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.CartItem;
import com.example.backend.module.domain.ports.in.CreateCartItemUseCasePortIn;
import com.example.backend.module.domain.ports.out.ICartItemRepositoryPortOut;

public class CreateCartItemUseCase implements CreateCartItemUseCasePortIn {

    private final ICartItemRepositoryPortOut cartItemRepositoryPortOut;

    public CreateCartItemUseCase(ICartItemRepositoryPortOut cartItemRepositoryPortOut) {
        this.cartItemRepositoryPortOut = cartItemRepositoryPortOut;
    }

    @Override
    public CartItem execute(CartItem cartItem) {
        return cartItemRepositoryPortOut.save(cartItem);
    }
}



