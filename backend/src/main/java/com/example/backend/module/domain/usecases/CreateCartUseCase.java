package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.Cart;
import com.example.backend.module.domain.ports.in.CreateCartUseCasePortIn;
import com.example.backend.module.domain.ports.out.ICartRepositoryPortOut;

public class CreateCartUseCase implements CreateCartUseCasePortIn {

    private final ICartRepositoryPortOut cartRepositoryPortOut;

    public CreateCartUseCase(ICartRepositoryPortOut cartRepositoryPortOut) {
        this.cartRepositoryPortOut = cartRepositoryPortOut;
    }

    @Override
    public Cart execute(Cart cart) {
        return cartRepositoryPortOut.save(cart);
    }
}



