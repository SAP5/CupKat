package com.example.cupcat.controller;

import com.example.cupcat.dto.ProdutoDTO;
import com.example.cupcat.model.Modelo;
import com.example.cupcat.model.Produto;
import com.example.cupcat.service.IProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    @Autowired
    private IProduto produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos(){
        return new ResponseEntity<>(produtoService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProduto(@Valid @RequestBody ProdutoDTO produto){
        produtoService.save(produto);
    }

    @GetMapping("/by_id/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable int id){
        return new ResponseEntity<>(produtoService.getProdutoById(id).get(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateProduto(@PathVariable int id, @Valid @RequestBody ProdutoDTO produto){
        produtoService.updateProduto(produto, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Produto> deleteProdutoById(@PathVariable int id){
        return new ResponseEntity<>(produtoService.removeProdutoById(id).get(), HttpStatus.OK);
    }
}
