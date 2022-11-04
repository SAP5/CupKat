package com.example.cupcat.service;

import com.example.cupcat.dto.CategoriaDTO;
import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.exception.NotFoundException;
import com.example.cupcat.model.Categoria;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface ICategoria {
    void save(CategoriaDTO categoriaDTO) throws AlreadyExistingException;
    List<Categoria> getAll();
    Optional<Categoria> getCategoriaById(int id) throws NoSuchElementException;
    void updateCategoria(CategoriaDTO categoriaDTO, int id) throws NoSuchElementException;
    Optional<Categoria> removeCategoriaById(int id) throws NoSuchElementException;
}
