package com.example.cupcat.service;

import com.example.cupcat.dto.FuncionarioDTO;
import com.example.cupcat.exception.errors.AlreadyExistingException;
import com.example.cupcat.model.Funcionario;
import com.example.cupcat.repository.FuncionarioRepo;
import com.example.cupcat.service.iinterface.IFuncionario;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FuncionarioService implements IFuncionario {
    private final FuncionarioRepo repo;
    private static final String MSG_ERROR_NOT_FOUND = "Funcionario não encontrado!";
    private static final String MSG_ERROR_ALREADY_EXISTING = "Funcionario já cadastrado!";

    @Override
    public void save(Funcionario funcionario) throws AlreadyExistingException, DataIntegrityViolationException {
        try{
            if(repo.existsById(funcionario.getId())) throw new AlreadyExistingException(MSG_ERROR_ALREADY_EXISTING);
            repo.save(funcionario);
        }catch (DataIntegrityViolationException ex){
            throw new AlreadyExistingException(MSG_ERROR_ALREADY_EXISTING);
        }
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

    @Override
    public List<FuncionarioDTO> getByEmail(String email) {
        return repo.findByEmailContaining(email).stream().map(FuncionarioDTO::new).collect(Collectors.toList());
    }
}
