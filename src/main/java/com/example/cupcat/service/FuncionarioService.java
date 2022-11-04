package com.example.cupcat.service;

import com.example.cupcat.dto.ClienteDTO;
import com.example.cupcat.dto.FuncionarioDTO;
import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.exception.NotFoundException;
import com.example.cupcat.model.Cliente;
import com.example.cupcat.model.Funcionario;
import com.example.cupcat.repository.FuncionarioRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    @Override
    public Optional<FuncionarioDTO> getFuncionarioById(int id) throws NotFoundException {
        return Optional.of(new FuncionarioDTO(repo.findById(id).get()));
    }

    @Override
    public void updateFuncionario(Funcionario funcionario) throws NotFoundException {
        repo.save(funcionario);
    }

    @Override
    public Optional<FuncionarioDTO> removeFuncionarioById(int id) throws NotFoundException {
        Optional<FuncionarioDTO> funcDTO = this.getFuncionarioById(id);
        repo.deleteById(id);

        return funcDTO;
    }
}
