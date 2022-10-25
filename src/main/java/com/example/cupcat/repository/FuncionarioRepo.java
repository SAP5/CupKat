package com.example.cupcat.repository;

import com.example.cupcat.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepo extends JpaRepository<Funcionario, Integer> {}