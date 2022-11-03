package com.example.cupcat.model;

import com.example.cupcat.dto.ProdutoDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private LocalDateTime created_at;

    @Column
    private LocalDateTime updated_at;

    @Column
    private int status = 1;

    @NotEmpty
    @Column(nullable = false)
    private String nome;

    @NotEmpty
    @Column
    private String descricao;

    @NotNull
    @Column(nullable = false)
    private double lucro;

    @PositiveOrZero
    @Column(nullable = false)
    private int estoque;

    @NotEmpty
    @ManyToMany
    @JoinTable(
            name = "produto_cor",
            joinColumns = @JoinColumn(name = "id_produto", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_cor", referencedColumnName = "id")
    )
    @JsonIgnoreProperties("produtos")
    @JsonBackReference
    private Set<Cor> cores;

    @NotEmpty
    @ManyToMany
    @JoinTable(
            name = "produto_tamanho",
            joinColumns = @JoinColumn(name = "id_produto", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_tamanho", referencedColumnName = "id")
    )
    @JsonBackReference
    @JsonIgnoreProperties("produtos")
    private Set<Tamanho> tamanhos;

    @NotEmpty
    @ManyToMany
    @JoinTable(
            name = "produto_categoria",
            joinColumns = @JoinColumn(name = "id_produto", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    )
    @JsonBackReference
    @JsonIgnoreProperties("produtos")
    private Set<Categoria> categorias;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_modelo")
    @JsonIgnoreProperties("produtos")
    @JsonBackReference
    private Modelo modelo;

    @Column
    private String imagem;

    public Produto(ProdutoDTO produtoDTO) {
        this.nome = produtoDTO.getNome();
        this.descricao = produtoDTO.getDescricao();
        this.lucro = produtoDTO.getLucro();
        this.estoque = produtoDTO.getEstoque();
    }
}
