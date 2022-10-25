package com.example.cupcat.repository;

import com.example.cupcat.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepo extends JpaRepository<Produto, Integer> {}
