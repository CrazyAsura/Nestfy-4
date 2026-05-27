package com.example.backend.module.adapter.out.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.module.domain.models.Money;

@Repository
public interface MoneyRepository extends JpaRepository<Money, Long> {

    public List<Money> findByName(String name);

    public List<Money> findByActive(Boolean active);
}
