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
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FuncionarioService implements IFuncionario{
    private final FuncionarioRepo repo;
    private static final String MSG_ERROR_NOT_FOUND = "Funcionario não encontrado!";

    @Override
    public void save(Funcionario funcionario) throws AlreadyExistingException {
        repo.save(funcionario);
    }

    @Override
    public List<FuncionarioDTO> getAll() {
        return repo.findAll().stream().map(FuncionarioDTO::new).collect(Collectors.toList());
    }

    @Override
    public Optional<FuncionarioDTO> getFuncionarioById(int id) throws NoSuchElementException {
        Optional<Funcionario> opFunc = repo.findById(id);

        if(opFunc.isEmpty()) throw new NoSuchElementException(MSG_ERROR_NOT_FOUND);

        return Optional.of(new FuncionarioDTO(opFunc.get()));
    }

    @Override
    public void updateFuncionario(Funcionario funcionario) throws NoSuchElementException {
        if(!repo.existsById(funcionario.getId())) throw new NoSuchElementException(MSG_ERROR_NOT_FOUND);

        repo.save(funcionario);
    }

    @Override
    public Optional<FuncionarioDTO> removeFuncionarioById(int id) throws NoSuchElementException {
        Optional<FuncionarioDTO> funcDTO = this.getFuncionarioById(id);

        if(funcDTO.isEmpty()) throw new NoSuchElementException(MSG_ERROR_NOT_FOUND);

        repo.deleteById(id);

        return funcDTO;
    }
}
