package com.example.cupcat.service;

import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.exception.NotFoundException;
import com.example.cupcat.model.Categoria;
import com.example.cupcat.model.Produto;
import com.example.cupcat.repository.CategoriaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CategoriaService implements ICategoria{
    private final CategoriaRepo repo;

    @Override
    public void save(Categoria categoria) throws AlreadyExistingException {
        repo.save(categoria);
    }

    @Override
    public List<Categoria> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Categoria> getCategoriaById(int id) throws NotFoundException {
        return repo.findById(id);
    }

    @Override
    public void updateCategoria(Categoria categoria) throws NotFoundException {
        repo.save(categoria);
    }

    @Override
    public Optional<Categoria> removeCategoriaById(int id) throws NotFoundException {
        Optional<Categoria> categoria = this.getCategoriaById(id);
        repo.deleteById(id);

        return categoria;
    }
}
