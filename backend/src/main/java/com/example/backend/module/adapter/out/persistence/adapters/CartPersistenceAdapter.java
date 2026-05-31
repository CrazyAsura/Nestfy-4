package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.domain.usecases.*;

@Component
public class CartPersistenceAdapter {

    private final CreateCartUseCase createCartUseCase;
    private final GetCartUseCase getCartUseCase;
    private final UpdateCartUseCase updateCartUseCase;
    private final DeleteCartUseCase deleteCartUseCase;
    private final ICartRepositoryPortOut cartRepositoryPortOut;

    @Autowired
    public CartPersistenceAdapter(CreateCartUseCase createCartUseCase,
            GetCartUseCase getCartUseCase,
            UpdateCartUseCase updateCartUseCase,
            DeleteCartUseCase deleteCartUseCase,
            ICartRepositoryPortOut cartRepositoryPortOut) {
        this.createCartUseCase = createCartUseCase;
        this.getCartUseCase = getCartUseCase;
        this.updateCartUseCase = updateCartUseCase;
        this.deleteCartUseCase = deleteCartUseCase;
        this.cartRepositoryPortOut = cartRepositoryPortOut;
    }

    public Optional<Cart> findById(Long id) {
        return Optional.ofNullable(getCartUseCase.execute(id));
    }

    public Iterable<Cart> findAll() {
        return cartRepositoryPortOut.findAll();
    }

    public Cart save(Cart entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (entity.getId() == null) {
            return createCartUseCase.execute(entity);
        } else {
            return updateCartUseCase.execute(entity);
        }
    }

    public void deleteById(Long id) {
        deleteCartUseCase.execute(id);
    }
    public List<Cart> findByUserId(Long userId) {
        return cartRepositoryPortOut.findByUserId(userId);
    }

    public List<Cart> findByActive(Boolean active) {
        return cartRepositoryPortOut.findByActive(active);
    }
}
