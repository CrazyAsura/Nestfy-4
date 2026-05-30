package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.CartItem;
import com.example.backend.module.domain.ports.in.GetCartItemUseCasePortIn;
import com.example.backend.module.domain.ports.out.ICartItemRepositoryPortOut;

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

