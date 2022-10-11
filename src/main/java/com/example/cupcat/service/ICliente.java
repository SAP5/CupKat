package com.example.cupcat.service;

import com.example.cupcat.dto.ClienteDTO;
import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.model.Cliente;

import java.util.List;

public interface ICliente {
    void save(Cliente cliente) throws AlreadyExistingException;
    List<ClienteDTO> getAll();
}
