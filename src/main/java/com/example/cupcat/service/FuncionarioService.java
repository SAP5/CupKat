package com.example.cupcat.service;

import com.example.cupcat.dto.FuncionarioDTO;
import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.model.Funcionario;
import com.example.cupcat.repository.FuncionarioRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FuncionarioService implements IFuncionario{
    private final FuncionarioRepo repo;

    @Override
    public void save(Funcionario funcionario) throws AlreadyExistingException {
        repo.save(funcionario);
    }

    @Override
    public List<FuncionarioDTO> getAll() {
        return repo.findAll().stream().map(FuncionarioDTO::new).collect(Collectors.toList());
    }
}
