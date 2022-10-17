package com.example.cupcat.service;

import com.example.cupcat.dto.ProdutoDTO;
import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.model.Produto;

import java.util.List;

public interface IProduto {
    void save(ProdutoDTO produto) throws AlreadyExistingException;
    List<Produto> getAll();
}
