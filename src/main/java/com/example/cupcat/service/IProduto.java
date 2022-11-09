package com.example.cupcat.service;

import com.example.cupcat.dto.ProdutoDTO;
import com.example.cupcat.dto.VProdutoDTO;
import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.model.Produto;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface IProduto {
    void save(ProdutoDTO produto) throws AlreadyExistingException;
    List<VProdutoDTO> getAll();
    VProdutoDTO getProdutoByIdView(int id) throws NoSuchElementException;
    Optional<Produto> getProdutoById(int id) throws NoSuchElementException;
    void updateProduto(ProdutoDTO produto, int id) throws NoSuchElementException;
    Optional<Produto> removeProdutoById(int id) throws NoSuchElementException;
    Optional<List<VProdutoDTO>> getProdutosByNome(String nome);
    List<Object> getCoresByProdutoId(int id);
//    Optional<List<Produto>> getProdutosByCategoria(int categoria);
//    Optional<List<Produto>> getProdutosByModelo(int modelo);
}
