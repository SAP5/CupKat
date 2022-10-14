package com.example.cupcat.service;

import com.example.cupcat.dto.ClienteDTO;
import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.exception.NotFoundException;
import com.example.cupcat.model.Cliente;
import com.example.cupcat.repository.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClienteService implements ICliente{
    @Autowired
    private ClienteRepo repo;

    @Override
    public void save(Cliente cliente) throws AlreadyExistingException {
        if(!repo.saveCliente(cliente)) throw new AlreadyExistingException("Cliente já cadastrado");
    }

    @Override
    public List<ClienteDTO> getAll() {
        return repo.getAll().stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    @Override
    public Optional<ClienteDTO> getClienteById(int id) throws NotFoundException {
        return Optional.of(new ClienteDTO(repo.getClienteById(id).get()));
    }
}
