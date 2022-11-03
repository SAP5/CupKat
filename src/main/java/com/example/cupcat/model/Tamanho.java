package com.example.cupcat.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
public class Tamanho implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    @Column
    private String tamanho;

    @ManyToMany(mappedBy = "tamanhos")
    @JsonIgnoreProperties("tamanhos")
    @JsonManagedReference
    private Set<Produto> produtos;
}
