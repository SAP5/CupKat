package com.example.cupcat.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
public class Categoria extends Model{
    @NotEmpty
    private String titulo;
    private String descricao;
}
