package com.example.cupcat.service;

import com.example.cupcat.dto.ProdutoDTO;
import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.model.Produto;
import com.example.cupcat.repository.ProdutoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoService implements IProduto{
    @Autowired
    private ProdutoRepo repo;

    @Override
    public void save(ProdutoDTO produto) throws AlreadyExistingException {
        if(!repo.saveProduto(produto, true, 0)) throw new AlreadyExistingException("Produto já cadastrado");
    }

    @Override
    public List<Produto> getAll() {
        return repo.getAll();
    }
}
