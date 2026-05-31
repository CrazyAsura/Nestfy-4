package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.CartItem;
import com.example.backend.module.domain.ports.in.CreateCartItemUseCasePortIn;
import com.example.backend.module.domain.ports.out.ICartItemRepositoryPortOut;

@Component
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



