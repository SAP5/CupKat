package com.example.cupcat.controller;

import com.example.cupcat.dto.ClienteDTO;
import com.example.cupcat.dto.FuncionarioDTO;
import com.example.cupcat.model.Cliente;
import com.example.cupcat.model.Funcionario;
import com.example.cupcat.service.ICliente;
import com.example.cupcat.service.IFuncionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioController {
    @Autowired
    private IFuncionario funcionarioService;

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> getAllFuncionarios(){
        return new ResponseEntity<>(funcionarioService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveFuncionario(@Valid @RequestBody Funcionario funcionario){
        funcionarioService.save(funcionario);
    }

    @GetMapping("/by_id/{id}")
    public ResponseEntity<FuncionarioDTO> getFuncionarioById(@PathVariable int id){
        return new ResponseEntity<>(funcionarioService.getFuncionarioById(id).get(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateFuncionario(@RequestBody Funcionario funcionario, @PathVariable int id){
        funcionario.setId(id);
        funcionarioService.updateFuncionario(funcionario);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<FuncionarioDTO> removeFuncionarioById(@PathVariable int id){
        return new ResponseEntity<>(funcionarioService.removeFuncionarioById(id).get(), HttpStatus.OK);
    }
}