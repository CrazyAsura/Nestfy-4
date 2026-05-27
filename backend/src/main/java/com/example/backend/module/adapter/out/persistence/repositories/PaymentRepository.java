package com.example.backend.module.adapter.out.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.module.domain.models.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    public List<Payment> findByOrderId(Long orderId);

    public List<Payment> findByMethod(String method);
    
    public List<Payment> findByAmount(Double amount);
    
    public List<Payment> findByStatus(String status);

    public List<Payment> findByActive(Boolean active);
}
