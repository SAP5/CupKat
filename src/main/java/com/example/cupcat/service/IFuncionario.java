package com.example.cupcat.service;

import com.example.cupcat.dto.FuncionarioDTO;
import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.model.Funcionario;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface IFuncionario {
    void save(Funcionario funcionario) throws AlreadyExistingException;
    List<FuncionarioDTO> getAll();
    Optional<FuncionarioDTO> getFuncionarioById(int id) throws NoSuchElementException;
    void updateFuncionario(Funcionario funcionario) throws NoSuchElementException;
    Optional<FuncionarioDTO> removeFuncionarioById(int id) throws NoSuchElementException;
    FuncionarioDTO getByEmail(String email) throws NotFoundException ;
}
