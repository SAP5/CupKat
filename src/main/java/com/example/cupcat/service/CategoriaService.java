package com.example.cupcat.service;

import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.exception.NotFoundException;
import com.example.cupcat.model.Categoria;
import com.example.cupcat.repository.CategoriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaService implements ICategoria{
    @Autowired
    private CategoriaRepo repo = new CategoriaRepo();

    @Override
    public void save(Categoria categoria) throws AlreadyExistingException {
        if(!repo.saveCategoria(categoria, true, 0)) throw new AlreadyExistingException("Categoria já cadastrada");
    }

    @Override
    public List<Categoria> getAll() {
        return repo.getAll();
    }

    @Override
    public Optional<Categoria> getCategoriaById(int id) throws NotFoundException {
        return repo.getCategoriaById(id);
    }

    @Override
    public void updateCategoria(Categoria categoria, int id) throws NotFoundException {
        if(!repo.updateCategoria(categoria, id)) throw new NotFoundException("Categoria não encontrada");
    }

    @Override
    public Optional<Categoria> removeCategoriaById(int id) throws NotFoundException {
        return repo.deleteCategoriaById(id);
    }
}
