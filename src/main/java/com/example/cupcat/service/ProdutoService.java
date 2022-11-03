package com.example.cupcat.service;

import com.example.cupcat.dto.ProdutoDTO;
import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.exception.NotFoundException;
import com.example.cupcat.model.Produto;
import com.example.cupcat.repository.ProdutoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdutoService implements IProduto{
    private final ProdutoRepo repo;
    private final IModelo modeloService;
    private final ICor corService;
    private final ICategoria catService;

    private final ITamanho tamService;

    @Override
    public void save(ProdutoDTO produtoDTO) throws AlreadyExistingException {
        Produto produto = createAttributes(produtoDTO);

        repo.save(produto);
    }

    @Override
    public List<Produto> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Produto> getProdutoById(int id) throws NotFoundException {
        System.out.println(repo.findById(id).get());
        return repo.findById(id);
    }

    @Override
    public void updateProduto(ProdutoDTO produtoDTO, int id) throws NotFoundException {
        Produto produto = createAttributes(produtoDTO);
        produto.setId(id);

        repo.save(produto);
    }

    @Override
    public Optional<Produto> removeProdutoById(int id) throws NotFoundException {
        Optional<Produto> produto = getProdutoById(id);

        repo.deleteById(id);

        return produto;
    }

    @Override
    public Optional<List<Produto>> getProdutosByNome(String nome) {
        return repo.findByNomeContaining(nome);
    }
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

    private Produto createAttributes(ProdutoDTO produtoDTO){
        Produto produto = new Produto(produtoDTO);
        produto.setModelo(modeloService.getModeloById(produtoDTO.getModelo()).get());
        produto.setCores(produtoDTO.getCores().stream().map(corId -> corService.getCorById(corId).get()).collect(Collectors.toSet()));
        produto.setTamanhos(produtoDTO.getTamanhos().stream().map(tamId -> tamService.getTamanhoById(tamId).get()).collect(Collectors.toSet()));
        produto.setCategorias(produtoDTO.getCategorias().stream().map(catId -> catService.getCategoriaById(catId).get()).collect(Collectors.toSet()));

        return produto;
    }
}
