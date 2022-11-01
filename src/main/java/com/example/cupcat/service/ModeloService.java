package com.example.cupcat.service;

import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.exception.NotFoundException;
import com.example.cupcat.model.Categoria;
import com.example.cupcat.model.Modelo;
import com.example.cupcat.repository.ModeloRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ModeloService implements IModelo{
    private final ModeloRepo repo;

    @Override
    public void save(Modelo modelo) throws AlreadyExistingException {
        repo.save(modelo);
    }

    @Override
    public List<Modelo> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Modelo> getModeloById(int id) throws NotFoundException {
        return repo.findById(id);
    }

    @Override
    public void updateModelo(Modelo modelo, int id) throws NotFoundException {
        modelo.setId(id);
        repo.save(modelo);
    }

    @Override
    public void removeModeloById(int id) throws NotFoundException {
        repo.deleteById(id);
    }
}
