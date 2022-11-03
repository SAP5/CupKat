package com.example.cupcat.service;

import com.example.cupcat.model.Cor;
import com.example.cupcat.repository.CorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CorService implements ICor{
    private final CorRepo repo;

    @Override
    public Optional<Cor> getCorById(int id) {
        return repo.findById(id);
    }
}
