package com.example.cupcat.service;

import com.example.cupcat.dto.ClienteDTO;
import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.exception.NotFoundException;
import com.example.cupcat.model.Categoria;
import com.example.cupcat.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ICategoria {
    void save(Categoria categoria) throws AlreadyExistingException;
    List<Categoria> getAll();
    Optional<Categoria> getCategoriaById(int id) throws NotFoundException;
    void updateCategoria(Categoria categoria, int id) throws NotFoundException;
    Optional<Categoria> removeCategoriaById(int id) throws NotFoundException;
}
