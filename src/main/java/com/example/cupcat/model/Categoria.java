package com.example.cupcat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categoria implements Serializable {
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
    private String titulo;

    @Column
    private String descricao;

    @ManyToMany(mappedBy = "categorias")
    @JsonIgnoreProperties("categorias")
    @JsonManagedReference
    @ToString.Exclude
    private Set<Produto> produtos;

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
