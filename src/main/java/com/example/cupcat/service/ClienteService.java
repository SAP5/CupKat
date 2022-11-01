package com.example.cupcat.service;

import com.example.cupcat.dto.ClienteDTO;
import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.exception.NotFoundException;
import com.example.cupcat.model.Cliente;
import com.example.cupcat.repository.ClienteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteService implements ICliente{
    private final ClienteRepo repo;

    @Override
    public void save(Cliente cliente) throws AlreadyExistingException {
        repo.save(cliente);
    }

    @Override
    public List<ClienteDTO> getAll() {
        return repo.findAll().stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    @Override
    public Optional<ClienteDTO> getClienteById(int id) throws NotFoundException {
        return Optional.of(new ClienteDTO(repo.findById(id).get()));
    }

    @Override
    public void updateCliente(Cliente cliente, int id) throws NotFoundException {
        repo.save(cliente);
    }

    @Override
    public void removeClienteById(int id) throws NotFoundException {
        repo.deleteById(id);
    }
}
