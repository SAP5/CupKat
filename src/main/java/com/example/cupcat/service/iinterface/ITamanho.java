package com.example.cupcat.service.iinterface;

import com.example.cupcat.model.Tamanho;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface ITamanho {
    Optional<Tamanho> getTamanhoById(int id) throws NoSuchElementException;
    List<Tamanho> getAll();
}
