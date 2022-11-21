package com.example.cupcat.service;

import com.example.cupcat.dto.ModeloDTO;
import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.model.Modelo;
import com.example.cupcat.repository.ModeloRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ModeloService implements IModelo {
    private final ModeloRepo repo;
    private static final String MSG_ERROR_NOT_FOUND = "Modelo não encontrado!";

    @Override
    public void save(ModeloDTO modeloDTO) throws AlreadyExistingException {
        repo.save(new Modelo(modeloDTO));
    }

    @Override
    public List<Modelo> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Modelo> getModeloById(int id) throws NoSuchElementException {
        Optional<Modelo> opModelo = repo.findById(id);

        if(opModelo.isEmpty()) throw new NoSuchElementException(MSG_ERROR_NOT_FOUND);

        return opModelo;
    }

    @Override
    public void updateModelo(ModeloDTO modeloDTO, int id) throws NoSuchElementException {
        if(!repo.existsById(id)) throw new NoSuchElementException(MSG_ERROR_NOT_FOUND);

        Modelo modelo = new Modelo(modeloDTO);
        modelo.setId(id);
        repo.save(modelo);
    }

    @Override
    public Optional<Modelo> removeModeloById(int id) throws NoSuchElementException, DataIntegrityViolationException {
        try{
            Optional<Modelo> modelo = this.getModeloById(id);

            if(modelo.isEmpty()) throw new NoSuchElementException(MSG_ERROR_NOT_FOUND);

            repo.deleteById(id);

            return modelo;
        }catch (DataIntegrityViolationException ex){
            throw new DataIntegrityViolationException("Você não pode deletar um modelo que tenha produtos associados!");
        }
    }
}
