package com.example.cupcat.service;

import com.example.cupcat.model.Tamanho;
import com.example.cupcat.repository.TamanhoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TamanhoService implements ITamanho{
    private final TamanhoRepo repo;

    @Override
    public Optional<Tamanho> getTamanhoById(int id) {
        return repo.findById(id);
    }
}
