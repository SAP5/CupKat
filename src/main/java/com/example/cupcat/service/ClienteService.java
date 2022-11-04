package com.example.cupcat.service;

import com.example.cupcat.dto.ClienteDTO;
import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.exception.NotFoundException;
import com.example.cupcat.model.Cliente;
import com.example.cupcat.repository.ClienteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteService implements ICliente{
    private final ClienteRepo repo;
    private static final String MSG_ERROR_NOT_FOUND = "Cliente não encontrado!";
    private static final String MSG_ERROR_ALREADY_EXISTING = "Cliente já cadastrado!";

    @Override
    public void save(Cliente cliente) throws AlreadyExistingException, DataIntegrityViolationException {
        try{
            if(cliente.getId() != 0) throw new AlreadyExistingException(MSG_ERROR_ALREADY_EXISTING);
            repo.save(cliente);
        } catch (DataIntegrityViolationException ex){
            throw new AlreadyExistingException(MSG_ERROR_ALREADY_EXISTING);
        }
    }

    @Override
    public List<ClienteDTO> getAll() {
        return repo.findAll().stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    @Override
    public Optional<ClienteDTO> getClienteById(int id) throws NoSuchElementException {
        Optional<Cliente> opCliente = repo.findById(id);

        if(opCliente.isEmpty()) throw new NoSuchElementException(MSG_ERROR_NOT_FOUND);

        return Optional.of(new ClienteDTO(opCliente.get()));
    }

    @Override
    public void updateCliente(Cliente cliente) throws NoSuchElementException {
        if(!repo.existsById(cliente.getId())) throw new NoSuchElementException(MSG_ERROR_NOT_FOUND);
        repo.save(cliente);
    }

    @Override
    public Optional<ClienteDTO> removeClienteById(int id) throws NoSuchElementException {
        Optional<ClienteDTO> clienteDTO = this.getClienteById(id);

        if(clienteDTO.isEmpty()) throw new NoSuchElementException(MSG_ERROR_NOT_FOUND);

        repo.deleteById(id);

        return clienteDTO;
    }
}
