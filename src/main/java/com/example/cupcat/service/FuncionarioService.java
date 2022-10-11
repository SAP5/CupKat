package com.example.cupcat.service;

import com.example.cupcat.dto.FuncionarioDTO;
import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.model.Funcionario;
import com.example.cupcat.repository.FuncionarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FuncionarioService implements IFuncionario{
    @Autowired
    FuncionarioRepo repo;

    @Override
    public void save(Funcionario funcionario) throws AlreadyExistingException {
        if(!repo.saveFuncionario(funcionario)) throw new AlreadyExistingException("Funcionario já cadastrado");
    }

    @Override
    public List<FuncionarioDTO> getAll() {
        return repo.getAll().stream().map(FuncionarioDTO::new).collect(Collectors.toList());
    }
}
