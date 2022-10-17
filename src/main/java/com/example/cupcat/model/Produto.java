package com.example.cupcat.model;

import com.example.cupcat.dto.ProdutoDTO;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto extends Model{
    @NotEmpty
    private String nome;
    @NotEmpty
    private String descricao;
    @NotNull
    private double lucro;
    @PositiveOrZero
    private int estoque;
    @NotEmpty
    private List<String> cores;
    @NotEmpty
    private List<String> tamanhos;
    @NotEmpty
    private List<@Valid Categoria> categorias;
    @NotNull
    private Modelo modelo;
    private String imagem;

    public Produto(ProdutoDTO produtoDTO){
        this.nome = produtoDTO.getNome();
        this.descricao = produtoDTO.getDescricao();
        this.lucro = produtoDTO.getLucro();
        this.estoque = produtoDTO.getEstoque();
        this.cores = produtoDTO.getCores();
        this.tamanhos = produtoDTO.getTamanhos();
    }
}
