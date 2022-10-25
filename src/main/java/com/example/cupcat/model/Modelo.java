package com.example.cupcat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Modelo{
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

    @NotNull
    @Min(value = 0, message = "O preço de custo deve ser maior que 0")
    @Column(nullable = false)
    private BigDecimal precoCusto;

    @NotEmpty
    @Column
    private String descricao;

    @OneToMany(mappedBy = "modelo")
    @JsonIgnoreProperties("modelo")
    private List<Produto> produtos;
}
