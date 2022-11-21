package com.example.cupcat.service;

import com.example.cupcat.dto.CarrinhoDTO;
import com.example.cupcat.dto.ItemCarrinhoDTO;
import com.example.cupcat.exception.OutOfStockException;
import com.example.cupcat.model.*;
import com.example.cupcat.repository.CarrinhoRepo;
import com.example.cupcat.repository.ClienteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarrinhoService implements ICarrinho{
    private final CarrinhoRepo repo;
    private final ICliente cliService;
    private final IProduto prodService;
    private final ICor corService;

    @Override
    public void save(CarrinhoDTO carrinhoDTO) {
        repo.save(createAttributes(carrinhoDTO));
    }

    @Override
    public List<Carrinho> getAllByCliente(int cliente) {
        cliService.getClienteById(cliente);
        return repo.findByCliente_Id(cliente);
    }

    private Carrinho createAttributes(CarrinhoDTO carrinhoDTO){
        Cliente cliente = cliService.getClienteCompById(carrinhoDTO.getCliente()).get();
        List<ItemCarrinhoDTO> itens = carrinhoDTO.getItensCarrinho();
        List<Produto> produtos = getProdutos(itens);

        validadeEstoque(produtos, itens);

        Carrinho carrinho = new Carrinho(itens, cliente, produtos, getCores(itens));
        atualizaEstoque(carrinho.getItensCarrinho());

        return carrinho;
    }

    private void validadeEstoque(List<Produto> produtos, List<ItemCarrinhoDTO> itens){
        for (int i = 0; i < produtos.size(); i++) {
            if(produtos.get(i).getEstoque() < itens.get(i).getQuantidade())
                throw new OutOfStockException("O estoque do produto: " +produtos.get(i).getNome()+ " é insufuciente!");
        }
    }

    private List<Produto> getProdutos(List<ItemCarrinhoDTO> itensCarrinhoDTO){
        return itensCarrinhoDTO.stream().map(item -> prodService.getProdutoById(item.getProduto()).get()).collect(Collectors.toList());
    }

    private List<Cor> getCores(List<ItemCarrinhoDTO> itensCarrinhoDTO){
        return itensCarrinhoDTO.stream().map(item -> corService.getCorById(item.getCor()).get()).collect(Collectors.toList());
    }

    private void atualizaEstoque(List<ItemCarrinho> itens){
        for (ItemCarrinho item : itens) {
            prodService.updateQtdProduto(item.getProduto(), item.getQuantidade());
        }
    }
}
