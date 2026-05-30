package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.Cart;
import com.example.backend.module.domain.ports.in.GetCartUseCasePortIn;
import com.example.backend.module.domain.ports.out.ICartRepositoryPortOut;

public class GetCartUseCase implements GetCartUseCasePortIn {
    private final ICartRepositoryPortOut cartRepositoryPortOut;

    public GetCartUseCase(ICartRepositoryPortOut cartRepositoryPortOut) {
        this.cartRepositoryPortOut = cartRepositoryPortOut;
    }

    @Override
    public Cart execute(Long id) {
        return cartRepositoryPortOut.findById(id).orElse(null);
    }
}
