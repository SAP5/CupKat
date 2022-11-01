package com.example.cupcat.service;

import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.exception.NotFoundException;
import com.example.cupcat.model.Produto;
import com.example.cupcat.repository.ProdutoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoService implements IProduto{
    private final ProdutoRepo repo;

    @Override
    public void save(Produto produto) throws AlreadyExistingException {
        repo.save(produto);
    }

    @Override
    public List<Produto> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Produto> getProdutoById(int id) throws NotFoundException {
        return repo.findById(id);
    }

    @Override
    public void updateProduto(Produto produto, int id) throws NotFoundException {
        produto.setId(id);
        repo.save(produto);
    }

    @Override
    public void removeProdutoById(int id) throws NotFoundException {
        repo.deleteById(id);
    }

//    @Override
//    public Optional<List<Produto>> getProdutosByNome(String nome) {
//        return repo.getProdutosByNome(nome);
//    }
//
//    @Override
//    public Optional<List<Produto>> getProdutosByCategoria(int categoria) {
//        return repo.getProdutosByCategoria(categoria);
//    }
//
//    @Override
//    public Optional<List<Produto>> getProdutosByModelo(int modelo) {
//        return repo.getProdutosByModelo(modelo);
//    }
}
