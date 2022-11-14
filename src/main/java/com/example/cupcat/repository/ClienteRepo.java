package com.example.cupcat.repository;

import com.example.cupcat.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepo extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByEmailContaining(String email);
}
