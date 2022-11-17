package com.example.cupcat.service;

import com.example.cupcat.dto.ProdutoDTO;
import com.example.cupcat.exception.AlreadyExistingException;
import com.example.cupcat.model.Produto;
import com.example.cupcat.repository.ProdutoRepo;
import com.example.cupcat.view.ProdutoView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdutoService implements IProduto {
    private final ProdutoRepo repo;
    private final IModelo modeloService;
    private final ICor corService;
    private final ICategoria catService;
    private final ITamanho tamService;
    private static final String MSG_ERROR_NOT_FOUND = "Produto não encontrado!";

    @Override
    public void save(ProdutoDTO produtoDTO) throws AlreadyExistingException {
        Produto produto = createAttributes(produtoDTO);

        repo.save(produto);
    }

    @Override
    public List<ProdutoView> getAll() {
        return repo.findAll().stream().map(ProdutoView::new).collect(Collectors.toList());
    }

    @Override
    public Optional<Produto> getProdutoById(int id) throws NoSuchElementException {
        Optional<Produto> produto = repo.findById(id);

        if(produto.isEmpty()) throw new NoSuchElementException(MSG_ERROR_NOT_FOUND);

        return produto;
    }

    @Override
    public ProdutoView getProdutoByIdView(int id) throws NoSuchElementException {
        Optional<Produto> produto = repo.findById(id);

        if(produto.isEmpty()) throw new NoSuchElementException(MSG_ERROR_NOT_FOUND);

        return new ProdutoView(produto.get());
    }

    @Override
    public void updateProduto(ProdutoDTO produtoDTO, int id) throws NoSuchElementException {
        if(!repo.existsById(id)) throw new NoSuchElementException(MSG_ERROR_NOT_FOUND);

        Produto produto = createAttributes(produtoDTO);
        produto.setId(id);

        repo.save(produto);
    }

    @Override
    public void updateQtdProduto(Produto produto, int quantidade) throws NoSuchElementException {
        produto.setEstoque(produto.getEstoque() - quantidade);

        repo.save(produto);
    }

    @Override
    public Optional<Produto> removeProdutoById(int id) throws NoSuchElementException {
        Optional<Produto> produto = getProdutoById(id);

        if(produto.isEmpty()) throw new NoSuchElementException(MSG_ERROR_NOT_FOUND);

        repo.deleteById(id);

        return produto;
    }

    @Override
    public Optional<List<ProdutoView>> getProdutosByNome(String nome) {
        return Optional.of(repo.findByNomeContaining(nome).get().stream()
                .map(ProdutoView::new).collect(Collectors.toList()));
    }

    @Override
    public List<Object> getCoresByProdutoId(int id) {
        return repo.getCoresByIdProduto(id);
    }

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
