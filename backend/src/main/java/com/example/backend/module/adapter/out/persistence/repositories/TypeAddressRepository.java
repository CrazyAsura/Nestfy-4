package com.example.backend.module.adapter.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.module.domain.models.TypeAddressEnum;
import com.example.backend.module.domain.models.TypeAddress;

@Repository
public interface TypeAddressRepository extends JpaRepository<TypeAddress, Long> {

    public Optional<TypeAddress> findByCode(String code);

    public List<TypeAddress> findByType(TypeAddressEnum type);

    public List<TypeAddress> findByActive(Boolean active);
}
