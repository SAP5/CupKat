package com.example.cupcat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto extends Model{
    private String nome;
    private String descricao;
    private double valorVenda;
    private double valorCusto;
    private int estoque;
    private List<Categoria> categorias;
    private String imagem;

    public void addCategoria(Categoria categoria){
        if(categorias == null)
            categorias = new ArrayList<>();

        categorias.add(categoria);
    }
}
