package com.example.cupcat.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class Modelo extends Model{
    @NotEmpty
    private String titulo;
    @NotNull
    @Min(value = 0, message = "O preço de custo deve ser maior que 0")
    private BigDecimal precoCusto;
    @NotEmpty
    private String descricao;
}
