package com.example.cupcat.controller;

import com.example.cupcat.model.Categoria;
import com.example.cupcat.service.ICategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("categorias")
public class CategoriaController {
    @Autowired
    private ICategoria categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategorias(){
        return new ResponseEntity<>(categoriaService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCategoria(@Valid @RequestBody Categoria categoria){
        categoriaService.save(categoria);
    }

    @GetMapping("/by_id/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable int id){
        return new ResponseEntity<>(categoriaService.getCategoriaById(id).get(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateCategoria(@PathVariable int id, @Valid @RequestBody Categoria categoria){
        categoriaService.updateCategoria(categoria, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Categoria> deleteCategoriaById(@PathVariable int id){
        return new ResponseEntity<>(categoriaService.removeCategoriaById(id).get(), HttpStatus.OK);
    }
}
