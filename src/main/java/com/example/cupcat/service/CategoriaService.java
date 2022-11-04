package com.example.cupcat.service;

import com.example.cupcat.dto.CategoriaDTO;
import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.model.Categoria;
import com.example.cupcat.repository.CategoriaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaService implements ICategoria{
    private final CategoriaRepo repo;
    private static final String MSG_ERROR_NOT_FOUND = "Categoria não encontrada!";

    @Override
    public void save(CategoriaDTO categoriaDTO){
        Categoria categoria = new Categoria(categoriaDTO);
        repo.save(categoria);
    }

    @Override
    public List<Categoria> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Categoria> getCategoriaById(int id) throws NoSuchElementException {
        Optional<Categoria> opCat = repo.findById(id);

        if(opCat.isEmpty()) throw new NoSuchElementException(MSG_ERROR_NOT_FOUND);
        return repo.findById(id);
    }

    @Override
    public void updateCategoria(CategoriaDTO categoriaDTO, int id) throws NoSuchElementException {
        if(!repo.existsById(id)) throw new NoSuchElementException(MSG_ERROR_NOT_FOUND);

        Categoria categoria = new Categoria(categoriaDTO);
        categoria.setId(id);

        repo.save(categoria);
    }

    @Override
    public Optional<Categoria> removeCategoriaById(int id) throws NoSuchElementException {
        Optional<Categoria> categoria = this.getCategoriaById(id);

        if(categoria.isEmpty()) throw new NoSuchElementException(MSG_ERROR_NOT_FOUND);

        repo.deleteById(id);

        return categoria;
    }
}
