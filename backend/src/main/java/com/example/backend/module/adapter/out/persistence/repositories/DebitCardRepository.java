package com.example.backend.module.adapter.out.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.module.domain.models.DebitCard;

@Repository
public interface DebitCardRepository extends JpaRepository<DebitCard, Long> {

    public List<DebitCard> findByCardNumber(String cardNumber);

    public List<DebitCard> findByActive(Boolean active);
}
