package com.example.cupcat.service;

import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.exception.NotFoundException;
import com.example.cupcat.model.Categoria;
import com.example.cupcat.model.Modelo;
import com.example.cupcat.repository.ModeloRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ModeloService implements IModelo{
    @Autowired
    private ModeloRepo repo;

    @Override
    public void save(Modelo modelo) throws AlreadyExistingException {
        if(!repo.saveModelo(modelo, true, 0)) throw new AlreadyExistingException("Modelo já cadastrado");
    }

    @Override
    public List<Modelo> getAll() {
        return repo.getAll();
    }

    @Override
    public Optional<Modelo> getModeloById(int id) throws NotFoundException {
        return repo.getModeloById(id);
    }

    @Override
    public void updateModelo(Modelo modelo, int id) throws NotFoundException {
        if(!repo.updateModelo(modelo, id)) throw new NotFoundException("Modelo não encontrado");
    }

    @Override
    public Optional<Modelo> removeModeloById(int id) throws NotFoundException {
        return repo.deleteModeloById(id);
    }
}
