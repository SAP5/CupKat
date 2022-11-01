package com.example.cupcat.service;

import com.example.cupcat.dto.ProdutoDTO;
import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.exception.NotFoundException;
import com.example.cupcat.model.Categoria;
import com.example.cupcat.model.Produto;

import java.util.List;
import java.util.Optional;

public interface IProduto {
    void save(Produto produto) throws AlreadyExistingException;
    List<Produto> getAll();
    Optional<Produto> getProdutoById(int id) throws NotFoundException;
    void updateProduto(Produto produto, int id) throws NotFoundException;
    void removeProdutoById(int id) throws NotFoundException;
//    Optional<List<Produto>> getProdutosByNome(String nome);
//    Optional<List<Produto>> getProdutosByCategoria(int categoria);
//    Optional<List<Produto>> getProdutosByModelo(int modelo);
}
