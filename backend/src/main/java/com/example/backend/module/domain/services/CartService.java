package com.example.backend.module.domain.services;

import com.example.backend.module.domain.models.Cart;
import com.example.backend.module.domain.ports.out.ICartRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateCartUseCase;
import com.example.backend.module.domain.usecases.DeleteCartUseCase;
import com.example.backend.module.domain.usecases.GetCartUseCase;
import com.example.backend.module.domain.usecases.UpdateCartUseCase;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CreateCartUseCase createCartUseCase;
    private final GetCartUseCase getCartUseCase;
    private final UpdateCartUseCase updateCartUseCase;
    private final DeleteCartUseCase deleteCartUseCase;

    public CartService(ICartRepositoryPortOut cartRepositoryPortOut) {
        this.createCartUseCase = new CreateCartUseCase(cartRepositoryPortOut);
        this.getCartUseCase = new GetCartUseCase(cartRepositoryPortOut);
        this.updateCartUseCase = new UpdateCartUseCase(cartRepositoryPortOut);
        this.deleteCartUseCase = new DeleteCartUseCase(cartRepositoryPortOut);
    }

    public Cart createCart(Cart cart) {
        return createCartUseCase.execute(cart);
    }

    public Cart getCart(Long id) {
        return getCartUseCase.execute(id);
    }

    public Cart updateCart(Cart cart) {
        return updateCartUseCase.execute(cart);
    }

    public void deleteCart(Long id) {
        deleteCartUseCase.execute(id);
    }
}
