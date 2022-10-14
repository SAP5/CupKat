package com.example.cupcat.controller;

import com.example.cupcat.dto.ClienteDTO;
import com.example.cupcat.model.Cliente;
import com.example.cupcat.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {
    @Autowired
    private ICliente clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAllClientes(){
        return new ResponseEntity<>(clienteService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCliente(@RequestBody Cliente cliente){
        clienteService.save(cliente);
    }

    @GetMapping("/by_id/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable int id){
        return new ResponseEntity<>(clienteService.getClienteById(id).get(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateCliente(@RequestBody Cliente cliente, @PathVariable int id){ clienteService.updateCliente(cliente, id); }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ClienteDTO> removeClienteById(@PathVariable int id){
        return new ResponseEntity<>(clienteService.removeClienteById(id).get(), HttpStatus.OK);
    }
}
