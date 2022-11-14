package com.example.cupcat.service;

import com.example.cupcat.model.Cor;
import com.example.cupcat.repository.CorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CorService implements ICor {
    private final CorRepo repo;
    private static final String MSG_ERROR_NOT_FOUND = "Cor não encontrada!";

    @Override
    public Optional<Cor> getCorById(int id) throws NoSuchElementException {
        Optional<Cor> opCor = repo.findById(id);

        if(opCor.isEmpty()) throw new NoSuchElementException(MSG_ERROR_NOT_FOUND);

        return opCor;
    }

    @Override
    public List<Cor> getAll() {
        return repo.findAll();
    }
}
