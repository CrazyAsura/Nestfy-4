package com.example.backend.module.domain.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.adapter.out.persistence.adapters.AdminPersistenceAdapter;

@Service
public class AdminService {

    private final AdminPersistenceAdapter adminPersistenceAdapter;

    @Autowired
    public AdminService(AdminPersistenceAdapter adminPersistenceAdapter) {
        this.adminPersistenceAdapter = adminPersistenceAdapter;
    }

    public Admin createAdmin(Admin admin) {
        if (admin == null) {
            throw new IllegalArgumentException("Admin cannot be null");
        }
        return adminPersistenceAdapter.save(admin);
    }

    public Admin getAdmin(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return adminPersistenceAdapter.findById(id).orElse(null);
    }

    public Admin updateAdmin(Admin admin) {
        if (admin == null) {
            throw new IllegalArgumentException("Admin cannot be null");
        }
        return adminPersistenceAdapter.save(admin);
    }

    public void deleteAdmin(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        adminPersistenceAdapter.deleteById(id);
    }
    public Optional<Admin> findByEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("email cannot be null");
        }
        return adminPersistenceAdapter.findByEmail(email);
    }

    public List<Admin> findByActive(Boolean active) {
        if (active == null) {
            throw new IllegalArgumentException("active cannot be null");
        }
        return adminPersistenceAdapter.findByActive(active);
    }

    public Iterable<Admin> findAll() {
        return adminPersistenceAdapter.findAll();
    }
}
