package com.example.cupcat.service;

import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.exception.NotFoundException;
import com.example.cupcat.model.Categoria;
import com.example.cupcat.model.Modelo;

import java.util.List;
import java.util.Optional;

public interface IModelo {
    void save(Modelo modelo) throws AlreadyExistingException;
    List<Modelo> getAll();
    Optional<Modelo> getModeloById(int id) throws NotFoundException;
    void updateModelo(Modelo modelo, int id) throws NotFoundException;
    void removeModeloById(int id) throws NotFoundException;
}
