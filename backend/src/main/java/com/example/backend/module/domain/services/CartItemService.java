package com.example.backend.module.domain.services;

import com.example.backend.module.domain.models.CartItem;
import com.example.backend.module.domain.ports.out.ICartItemRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateCartItemUseCase;
import com.example.backend.module.domain.usecases.DeleteCartItemUseCase;
import com.example.backend.module.domain.usecases.GetCartItemUseCase;
import com.example.backend.module.domain.usecases.UpdateCartItemUseCase;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {
    private final CreateCartItemUseCase createCartItemUseCase;
    private final GetCartItemUseCase getCartItemUseCase;
    private final UpdateCartItemUseCase updateCartItemUseCase;
    private final DeleteCartItemUseCase deleteCartItemUseCase;

    public CartItemService(ICartItemRepositoryPortOut cartItemRepositoryPortOut) {
        this.createCartItemUseCase = new CreateCartItemUseCase(cartItemRepositoryPortOut);
        this.getCartItemUseCase = new GetCartItemUseCase(cartItemRepositoryPortOut);
        this.updateCartItemUseCase = new UpdateCartItemUseCase(cartItemRepositoryPortOut);
        this.deleteCartItemUseCase = new DeleteCartItemUseCase(cartItemRepositoryPortOut);
    }

    public CartItem createCartItem(CartItem cartitem) {
        return createCartItemUseCase.execute(cartitem);
    }

    public CartItem getCartItem(Long id) {
        return getCartItemUseCase.execute(id);
    }

    public CartItem updateCartItem(CartItem cartitem) {
        return updateCartItemUseCase.execute(cartitem);
    }

    public void deleteCartItem(Long id) {
        deleteCartItemUseCase.execute(id);
    }
}
