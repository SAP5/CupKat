package com.example.cupcat.service;

import com.example.cupcat.dto.ClienteDTO;
import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.exception.NotFoundException;
import com.example.cupcat.model.Cliente;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface ICliente {
    void save(Cliente cliente) throws AlreadyExistingException;
    List<ClienteDTO> getAll();
    Optional<ClienteDTO> getClienteById(int id) throws NoSuchElementException;
    void updateCliente(Cliente cliente) throws NoSuchElementException;
    Optional<ClienteDTO> removeClienteById(int id) throws NoSuchElementException;
    ClienteDTO getByEmail(String email) throws NotFoundException;
}
