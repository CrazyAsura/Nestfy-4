package com.example.backend.module.domain.ports.out;

import java.util.List;
import java.util.Optional;

import com.example.backend.module.domain.models.DebitCard;

public interface DebitCardRepositoryPortOut extends IRepositoryPortOut<DebitCard, Long> {

    public Optional<DebitCard> findByCardNumber(String cardNumber);

    public List<DebitCard> findByActive(Boolean active);
    
    public List<DebitCard> findByClientId(Long clientId);

}
