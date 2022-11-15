package com.example.cupcat.service;

import com.example.cupcat.dto.ModeloDTO;
import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.model.Modelo;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface IModelo {
    void save(ModeloDTO modeloDTO) throws AlreadyExistingException;
    List<Modelo> getAll();
    Optional<Modelo> getModeloById(int id) throws NoSuchElementException;
    void updateModelo(Modelo modelo, int id) throws NoSuchElementException;
    Optional<Modelo> removeModeloById(int id) throws NoSuchElementException, DataIntegrityViolationException;
}
