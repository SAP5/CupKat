package com.example.cupcat.service;

import com.example.cupcat.dto.CategoriaDTO;
import com.example.cupcat.model.Categoria;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface ICategoria {
    void save(CategoriaDTO categoriaDTO);
    List<Categoria> getAll();
    Optional<Categoria> getCategoriaById(int id) throws NoSuchElementException;
    void updateCategoria(CategoriaDTO categoriaDTO, int id) throws NoSuchElementException;
    Optional<Categoria> removeCategoriaById(int id) throws NoSuchElementException;
}
