package com.example.cupcat.dto;

import com.example.cupcat.model.Categoria;
import com.example.cupcat.model.Modelo;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.List;

@Data
public class ProdutoDTO {
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
    private List<Integer> categorias;
    @NotNull
    private int modelo;
    private String imagem;
}
