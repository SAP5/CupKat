package com.example.cupcat.view;

import com.example.cupcat.model.Categoria;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoriaView {
    private int id;
    private String titulo;
    private String descricao;

    public CategoriaView(Categoria categoria){
        this.setId(categoria.getId());
        this.setTitulo(categoria.getTitulo());
        this.setDescricao(categoria.getDescricao());
    }
}
