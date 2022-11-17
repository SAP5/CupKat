package com.example.cupcat.service;

import com.example.cupcat.dto.CarrinhoDTO;
import com.example.cupcat.model.Carrinho;

import java.util.List;

public interface ICarrinho {
    void save(CarrinhoDTO carrinhoDTO);
    List<Carrinho> getAllByCliente(int cliente);
}
