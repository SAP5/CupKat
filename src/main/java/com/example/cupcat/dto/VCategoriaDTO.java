package com.example.cupcat.dto;

import com.example.cupcat.model.Categoria;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class VCategoriaDTO implements Serializable{
    private int id;
    private String titulo;
    private String descricao;

    public VCategoriaDTO(Categoria categoria){
        this.setId(categoria.getId());
        this.setTitulo(categoria.getTitulo());
        this.setDescricao(categoria.getDescricao());
    }
}
