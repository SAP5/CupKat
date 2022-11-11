package com.example.cupcat.service;

import com.example.cupcat.model.Cor;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface ICor {
    Optional<Cor> getCorById(int id) throws NoSuchElementException;
    List<Cor> getAll();
}
