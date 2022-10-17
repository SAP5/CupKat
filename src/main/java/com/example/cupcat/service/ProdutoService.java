package com.example.cupcat.service;

import com.example.cupcat.dto.ProdutoDTO;
import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.exception.NotFoundException;
import com.example.cupcat.model.Produto;
import com.example.cupcat.repository.ProdutoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Produto> getProdutoById(int id) throws NotFoundException {
        return repo.getProdutoById(id);
    }

    @Override
    public void updateProduto(ProdutoDTO produto, int id) throws NotFoundException {
        if(!repo.updateProduto(produto, id)) throw new NotFoundException("Produto não encontrado");
    }

    @Override
    public Optional<Produto> removeProdutoById(int id) throws NotFoundException {
        return repo.deleteProdutoById(id);
    }

    @Override
    public Optional<List<Produto>> getProdutosByNome(String nome) {
        return repo.getProdutosByNome(nome);
    }
}
