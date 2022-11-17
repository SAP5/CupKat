package com.example.cupcat.repository;

import com.example.cupcat.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarrinhoRepo extends JpaRepository<Carrinho, Integer> {
    List<Carrinho> findByCliente_Id(int id);
}
