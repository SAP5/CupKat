package com.example.cupcat.repository;

import com.example.cupcat.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FuncionarioRepo extends JpaRepository<Funcionario, Integer> {
    Optional<Funcionario> findByEmailContaining(String email);
}