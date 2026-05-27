package com.example.backend.module.adapter.out.persistence.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.module.domain.models.Address;
import com.example.backend.module.domain.models.Client;
import com.example.backend.module.domain.models.Order;
import com.example.backend.module.domain.models.Payment;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    public List<Order> findByClient(Client client);

    public List<Order> findByStatus(String status);

    public List<Order> findByDate(LocalDate date);

    public List<Order> findByTotal(Double total);

    public List<Order> findByPayment(Payment payment);

    public List<Order> findByAddress(Address address);

    public List<Order> findByActive(Boolean active);
}
