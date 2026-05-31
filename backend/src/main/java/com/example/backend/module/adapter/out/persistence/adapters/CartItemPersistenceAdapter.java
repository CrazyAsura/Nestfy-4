package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.domain.usecases.*;

@Component
public class CartItemPersistenceAdapter {

    private final CreateCartItemUseCase createCartItemUseCase;
    private final GetCartItemUseCase getCartItemUseCase;
    private final UpdateCartItemUseCase updateCartItemUseCase;
    private final DeleteCartItemUseCase deleteCartItemUseCase;
    private final ICartItemRepositoryPortOut cartItemRepositoryPortOut;

    @Autowired
    public CartItemPersistenceAdapter(CreateCartItemUseCase createCartItemUseCase,
            GetCartItemUseCase getCartItemUseCase,
            UpdateCartItemUseCase updateCartItemUseCase,
            DeleteCartItemUseCase deleteCartItemUseCase,
            ICartItemRepositoryPortOut cartItemRepositoryPortOut) {
        this.createCartItemUseCase = createCartItemUseCase;
        this.getCartItemUseCase = getCartItemUseCase;
        this.updateCartItemUseCase = updateCartItemUseCase;
        this.deleteCartItemUseCase = deleteCartItemUseCase;
        this.cartItemRepositoryPortOut = cartItemRepositoryPortOut;
    }

    public Optional<CartItem> findById(Long id) {
        return Optional.ofNullable(getCartItemUseCase.execute(id));
    }

    public Iterable<CartItem> findAll() {
        return cartItemRepositoryPortOut.findAll();
    }

    public CartItem save(CartItem entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (entity.getId() == null) {
            return createCartItemUseCase.execute(entity);
        } else {
            return updateCartItemUseCase.execute(entity);
        }
    }

    public void deleteById(Long id) {
        deleteCartItemUseCase.execute(id);
    }
    public List<CartItem> findByCartId(Long cartId) {
        return cartItemRepositoryPortOut.findByCartId(cartId);
    }

    public List<CartItem> findByActive(Boolean active) {
        return cartItemRepositoryPortOut.findByActive(active);
    }
}
