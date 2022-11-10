package com.example.cupcat.service;

import com.example.cupcat.model.Tamanho;
import repository.TamanhoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TamanhoService implements ITamanho{
    private final TamanhoRepo repo;
    private static final String MSG_ERROR_NOT_FOUND = "Tamanho não encontrado!";

    @Override
    public Optional<Tamanho> getTamanhoById(int id) throws NoSuchElementException {
        Optional<Tamanho> opTamanho = repo.findById(id);

        if(opTamanho.isEmpty()) throw new NoSuchElementException(MSG_ERROR_NOT_FOUND);

        return opTamanho;
    }

    @Override
    public List<Tamanho> getAll() {
        return repo.findAll();
    }
}
