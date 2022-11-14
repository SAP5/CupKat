package com.example.cupcat.repository;

import com.example.cupcat.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloRepo extends JpaRepository<Modelo, Integer> {}