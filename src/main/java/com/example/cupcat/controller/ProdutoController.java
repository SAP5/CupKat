package com.example.cupcat.controller;

import com.example.cupcat.dto.ProdutoDTO;
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
}
