package com.example.cupcat.dto;

import com.example.cupcat.model.Categoria;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CategoriaDTO implements Serializable{
    private String titulo;
    private String descricao;

    public CategoriaDTO(Categoria categoria){
        this.setTitulo(categoria.getTitulo());
        this.setDescricao(categoria.getDescricao());
    }
}
