package com.example.cupcat.controller;

import com.example.cupcat.dto.CategoriaDTO;
import com.example.cupcat.model.Categoria;
import com.example.cupcat.service.ICategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO){
        categoriaService.save(categoriaDTO);
    }

    @GetMapping("/by_id/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable int id){
        return new ResponseEntity<>(categoriaService.getCategoriaById(id).get(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCategoria(@PathVariable int id, @Valid @RequestBody Categoria categoria){
        categoria.setId(id);
        categoriaService.updateCategoria(categoria);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CategoriaDTO> deleteCategoriaById(@PathVariable int id){
        return new ResponseEntity<>(new CategoriaDTO(categoriaService.removeCategoriaById(id).get()), HttpStatus.OK);
    }
}
