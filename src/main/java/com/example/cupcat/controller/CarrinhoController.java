package com.example.cupcat.controller;

import com.example.cupcat.dto.CarrinhoDTO;
import com.example.cupcat.model.Carrinho;
import com.example.cupcat.service.ICarrinho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {
    @Autowired
    private ICarrinho service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@RequestBody CarrinhoDTO carrinhoDTO){
        service.save(carrinhoDTO);
        return "Carrinho salvo com sucesso!";
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Carrinho>> findByCliente(@PathVariable int id){
        return new ResponseEntity<>(service.getAllByCliente(id), HttpStatus.OK);
    }
}
