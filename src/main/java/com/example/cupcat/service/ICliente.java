package com.example.cupcat.service;

import com.example.cupcat.dto.ClienteDTO;
import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.model.Cliente;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface ICliente {

    void save(ClienteDTO clienteDTO) throws AlreadyExistingException, DataIntegrityViolationException;

    List<ClienteDTO> getAll();
    Optional<ClienteDTO> getClienteById(int id) throws NoSuchElementException;

    Optional<Cliente> getClienteCompById(int id) throws NoSuchElementException;

    void updateCliente(ClienteDTO clienteDTO) throws NoSuchElementException;

    Optional<ClienteDTO> removeClienteById(int id) throws NoSuchElementException;
    ClienteDTO getByEmail(String email) throws NoSuchElementException;
}
