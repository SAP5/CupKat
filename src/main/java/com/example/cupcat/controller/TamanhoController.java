package com.example.cupcat.controller;

import com.example.cupcat.model.Tamanho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tamanhos")
public class TamanhoController {
    @Autowired
    private ITamanho tamService;

    @GetMapping
    public ResponseEntity<List<Tamanho>> getAll(){
        return new ResponseEntity<>(tamService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tamanho> getTamanhoById(@PathVariable int id){
        return new ResponseEntity<>(tamService.getTamanhoById(id).get(), HttpStatus.OK);
    }
}
