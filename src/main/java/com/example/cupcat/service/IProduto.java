package com.example.cupcat.service;

import com.example.cupcat.dto.ProdutoDTO;
import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.model.Produto;
import com.example.cupcat.view.ProdutoView;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface IProduto {
    void save(ProdutoDTO produto) throws AlreadyExistingException;

    List<ProdutoView> getAll();
    Optional<Produto> getProdutoById(int id) throws NoSuchElementException;
    ProdutoView getProdutoByIdView(int id) throws NoSuchElementException;
    void updateProduto(ProdutoDTO produto, int id) throws NoSuchElementException;
    Optional<Produto> removeProdutoById(int id) throws NoSuchElementException;
    Optional<List<ProdutoView>> getProdutosByNome(String nome);
    List<Object> getCoresByProdutoId(int id);
//    Optional<List<Produto>> getProdutosByCategoria(int categoria);
//    Optional<List<Produto>> getProdutosByModelo(int modelo);
}
