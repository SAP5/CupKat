package com.example.cupcat.dto;

import com.example.cupcat.model.Modelo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class VModeloDTO implements Serializable {
    private int id;
    private String titulo;
    private BigDecimal precoCusto;
    private String descricao;

    public VModeloDTO(Modelo modelo){
        this.setId(modelo.getId());
        this.setTitulo(modelo.getTitulo());
        this.setPrecoCusto(modelo.getPrecoCusto());
        this.setDescricao(modelo.getDescricao());
    }
}
