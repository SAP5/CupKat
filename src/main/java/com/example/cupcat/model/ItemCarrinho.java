package com.example.cupcat.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemCarrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantidade;

    private BigDecimal valorProduto;

    private BigDecimal valorPago;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_cor")
    @JsonIgnoreProperties("itensCarrinho")
    private Cor cor;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_tamanho")
    @JsonIgnoreProperties("itensCarrinho")
    private Tamanho tamanho;

    @NotNull
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_produto")
    @JsonIgnoreProperties("itensCarrinho")
    private Produto produto;

    @NotNull
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_carrinho")
    @JsonIgnoreProperties("itensCarrinho")
    private Carrinho carrinho;
}
