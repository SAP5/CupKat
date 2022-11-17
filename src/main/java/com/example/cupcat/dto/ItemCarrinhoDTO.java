package com.example.cupcat.dto;

import com.example.cupcat.model.Carrinho;
import com.example.cupcat.model.Cor;
import com.example.cupcat.model.ItemCarrinho;
import com.example.cupcat.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemCarrinhoDTO {
    private int produto;
    private int quantidade;
    private int cor;

    public ItemCarrinho createItemCarrinho(ItemCarrinhoDTO itemCarrinhoDTO, Produto produto, Cor cor, Carrinho carrinho){
        ItemCarrinho itemCarrinho = new ItemCarrinho();

        itemCarrinho.setQuantidade(itemCarrinhoDTO.getQuantidade());
        itemCarrinho.setProduto(produto);
        itemCarrinho.setCor(cor);
        itemCarrinho.setCarrinho(carrinho);

        return itemCarrinho;
    }

    public ItemCarrinhoDTO(ItemCarrinho itemCarrinho) {
        this.produto = itemCarrinho.getProduto().getId();
        this.quantidade = itemCarrinho.getQuantidade();
        this.cor = itemCarrinho.getCor().getId();
    }
}
