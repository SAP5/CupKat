package com.example.cupcat.view;

import com.example.cupcat.model.Modelo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ModeloView {
    private int id;
    private String titulo;
    private BigDecimal precoCusto;
    private String descricao;

    public ModeloView(Modelo modelo){
        this.setId(modelo.getId());
        this.setTitulo(modelo.getTitulo());
        this.setPrecoCusto(modelo.getPrecoCusto());
        this.setDescricao(modelo.getDescricao());
    }
}
