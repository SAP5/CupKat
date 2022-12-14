package com.example.cupcat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
    @ToString.Exclude
    private Set<Produto> produtos;

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
