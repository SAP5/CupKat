package com.example.cupcat.service;

import com.example.cupcat.dto.ProdutoDTO;
import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.exception.NotFoundException;
import com.example.cupcat.model.Categoria;
import com.example.cupcat.model.Produto;

import java.util.List;
import java.util.Optional;

public interface IProduto {
    void save(ProdutoDTO produto) throws AlreadyExistingException;
    List<Produto> getAll();
    Optional<Produto> getProdutoById(int id) throws NotFoundException;
    void updateProduto(ProdutoDTO produto, int id) throws NotFoundException;
    Optional<Produto> removeProdutoById(int id) throws NotFoundException;
}
