package com.example.cupcat.controller;

import com.example.cupcat.model.Cor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cores")
public class CorController {
    @Autowired
    private ICor corService;

    @GetMapping
    public ResponseEntity<List<Cor>> getAll(){
        return new ResponseEntity<>(corService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cor> getCorById(@PathVariable int id){
        return new ResponseEntity<>(corService.getCorById(id).get(), HttpStatus.OK);
    }
}
