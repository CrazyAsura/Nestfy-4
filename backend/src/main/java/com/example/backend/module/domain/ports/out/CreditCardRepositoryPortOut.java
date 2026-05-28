package com.example.backend.module.domain.ports.out;

import java.util.List;
import java.util.Optional;

import com.example.backend.module.domain.models.CreditCard;

public interface CreditCardRepositoryPortOut extends IRepositoryPortOut<CreditCard, Long> {

    public Optional<CreditCard> findByCardNumber(String cardNumber);

    public List<CreditCard> findByActive(Boolean active);

}
