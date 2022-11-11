package com.example.cupcat.controller;

import com.example.cupcat.dto.ModeloDTO;
import com.example.cupcat.model.Modelo;
import com.example.cupcat.service.IModelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("modelos")
public class ModeloController {
    @Autowired
    private IModelo modeloService;

    @GetMapping
    public ResponseEntity<List<Modelo>> getAllModelos(){
        return new ResponseEntity<>(modeloService.getAll(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveModelo(@Valid @RequestBody ModeloDTO modeloDTO){
        modeloService.save(modeloDTO);
    }

    @GetMapping("/by_id/{id}")
    public ResponseEntity<Modelo> getModeloById(@PathVariable int id){
        return new ResponseEntity<>(modeloService.getModeloById(id).get(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateModelo(@PathVariable int id, @Valid @RequestBody Modelo modelo){
        modeloService.updateModelo(modelo, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ModeloDTO> deleteModeloById(@PathVariable int id){
        return new ResponseEntity<>(new ModeloDTO(modeloService.removeModeloById(id).get()), HttpStatus.OK);
    }
}
