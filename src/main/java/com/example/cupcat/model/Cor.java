package com.example.cupcat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cor;

    @ManyToMany(mappedBy = "cores")
    @JsonIgnoreProperties("cores")
    @JsonManagedReference
    @ToString.Exclude
    private Set<Produto> produtos;

    @OneToMany(mappedBy = "cor")
    @JsonIgnoreProperties("cor")
    @JsonManagedReference
    @ToString.Exclude
    private List<ItemCarrinho> itemCarrinho;

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public Cor(int id, String nome, String cor) {
        this.id = id;
        this.nome = nome;
        this.cor = cor;
    }
}
