package com.example.cupcat.repository;

import com.example.cupcat.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepo extends JpaRepository<Produto, Integer> {
    Optional<List<Produto>> findByNomeContaining(String nome);
    @Query(value = "select * from cor where cor.id in (select id_cor from produto_cor where id_produto = :id)", nativeQuery = true)
    List<Object> getCoresByIdProduto(int id);
}