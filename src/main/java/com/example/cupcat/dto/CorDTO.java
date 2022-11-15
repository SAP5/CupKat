package com.example.cupcat.dto;

import com.example.cupcat.model.Cor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CorDTO {
    private int id;
    private String nome;
    private String cor;

    public CorDTO(Cor cor) {
        this.id = cor.getId();
        this.nome = cor.getNome();
        this.cor = cor.getCor();
    }
}