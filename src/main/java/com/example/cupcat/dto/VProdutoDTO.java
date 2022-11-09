package com.example.cupcat.dto;

import com.example.cupcat.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VProdutoDTO {
    private int id;
    private String nome;
    private String descricao;
    private double lucro;
    private int estoque;
    private List<CorDTO> cores;
    private List<TamanhoDTO> tamanhos;
    private List<CategoriaDTO> categorias;
    private ModeloDTO modelo;
    private String imagem;

    public VProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.lucro = produto.getLucro();
        this.estoque = produto.getEstoque();
        this.cores = produto.getCores().stream().map(cor -> new CorDTO(cor)).collect(Collectors.toList());
        this.tamanhos = produto.getTamanhos().stream().map(tamanho -> new TamanhoDTO(tamanho)).collect(Collectors.toList());
        this.categorias = produto.getCategorias().stream().map(categoria -> new CategoriaDTO(categoria)).collect(Collectors.toList());
        this.modelo = new ModeloDTO(produto.getModelo());
        this.imagem = produto.getImagem();
    }
}
