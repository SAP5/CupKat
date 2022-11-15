package com.example.cupcat.view;

import com.example.cupcat.dto.CategoriaDTO;
import com.example.cupcat.dto.CorDTO;
import com.example.cupcat.dto.ModeloDTO;
import com.example.cupcat.dto.TamanhoDTO;
import com.example.cupcat.model.Produto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class ProdutoView {
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

    public ProdutoView(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.lucro = produto.getLucro();
        this.estoque = produto.getEstoque();
        this.cores = produto.getCores().stream().map(CorDTO::new).collect(Collectors.toList());
        this.tamanhos = produto.getTamanhos().stream().map(TamanhoDTO::new).collect(Collectors.toList());
        this.categorias = produto.getCategorias().stream().map(CategoriaDTO::new).collect(Collectors.toList());
        this.modelo = new ModeloDTO(produto.getModelo());
        this.imagem = produto.getImagem();
    }
}
