package com.example.cupcat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Tamanho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    @Column
    private String tamanho;

    @ManyToMany
    @JoinTable(
            name = "produto_tamanho",
            joinColumns = @JoinColumn(name = "id_tamanho", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_produto", referencedColumnName = "id")
    )
    @JsonIgnoreProperties("tamanhos")
    private Set<Produto> produtos;
}
