package com.example.cupcat.service;

import com.example.cupcat.dto.FuncionarioDTO;
import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.model.Funcionario;

import java.util.List;

public interface IFuncionario {
    void save(Funcionario funcionario) throws AlreadyExistingException;
    List<FuncionarioDTO> getAll();
}
