package com.example.cupcat.service;

import com.example.cupcat.model.Cor;

import java.util.Optional;

public interface ICor {
    Optional<Cor> getCorById(int id);
}
