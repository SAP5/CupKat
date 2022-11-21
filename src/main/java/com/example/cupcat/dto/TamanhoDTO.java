package com.example.cupcat.dto;

import com.example.cupcat.model.Tamanho;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TamanhoDTO {
    private int id;
    private String nome;
    private String tamanho;

    public TamanhoDTO(Tamanho tamanho) {
        this.id = tamanho.getId();
        this.nome = tamanho.getNome();
        this.tamanho = tamanho.getTamanho();
    }
}