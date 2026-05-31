package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.CartItem;
import com.example.backend.module.domain.ports.in.GetCartItemUseCasePortIn;
import com.example.backend.module.domain.ports.out.ICartItemRepositoryPortOut;

@Component
public class GetCartItemUseCase implements GetCartItemUseCasePortIn {
    private final ICartItemRepositoryPortOut cartItemRepositoryPortOut;

    public GetCartItemUseCase(ICartItemRepositoryPortOut cartItemRepositoryPortOut) {
        this.cartItemRepositoryPortOut = cartItemRepositoryPortOut;
    }

    @Override
    public CartItem execute(Long id) {
        return cartItemRepositoryPortOut.findById(id).orElse(null);
    }
}

