package com.example.cupcat.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Data
public class ProdutoDTO extends ModelDTO{
    @NotEmpty
    private String nome;
    @NotEmpty
    private String descricao;
    @NotNull
    private double lucro;
    @PositiveOrZero
    private int estoque;
    @NotEmpty
    private List<Integer> cores;
    @NotEmpty
    private List<Integer> tamanhos;
    @NotEmpty
    private List<Integer> categorias;
    @NotNull
    private int modelo;
    private String imagem;
}
