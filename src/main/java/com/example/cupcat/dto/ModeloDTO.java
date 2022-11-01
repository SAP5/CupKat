package com.example.cupcat.dto;

import com.example.cupcat.model.Funcionario;
import com.example.cupcat.model.Modelo;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ModeloDTO implements Serializable {
    private String titulo;
    private BigDecimal precoCusto;
    private String descricao;

    public ModeloDTO(Modelo modelo){
        this.setTitulo(modelo.getTitulo());
        this.setPrecoCusto(modelo.getPrecoCusto());
        this.setDescricao(modelo.getDescricao());
    }
}
