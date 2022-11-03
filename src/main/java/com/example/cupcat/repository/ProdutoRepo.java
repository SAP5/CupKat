package com.example.cupcat.repository;

import com.example.cupcat.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepo extends JpaRepository<Produto, Integer> {
    Optional<List<Produto>> findByNomeContaining(String nome);
}
