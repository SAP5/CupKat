package com.example.cupcat.service;

import com.example.cupcat.model.Tamanho;

import java.util.Optional;

public interface ITamanho {
    Optional<Tamanho> getTamanhoById(int id);
}
