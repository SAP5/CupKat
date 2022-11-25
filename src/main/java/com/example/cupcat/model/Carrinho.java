package com.example.cupcat.model;

import com.example.cupcat.dto.ItemCarrinhoDTO;
import com.example.cupcat.enums.Status;
import com.example.cupcat.enums.validation.StatusValue;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@StatusValue(enumClass = Status.class)
    private Status status;

    private BigDecimal valorTotal = new BigDecimal(BigInteger.ZERO);

    @OneToMany(mappedBy = "carrinho", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JsonIgnoreProperties("carrinho")
    @JsonManagedReference
    @ToString.Exclude
    private List<ItemCarrinho> itensCarrinho;

    @NotNull
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_cliente")
    @JsonIgnoreProperties("carrinhos")
    private Cliente cliente;

    public Carrinho(List<ItemCarrinhoDTO> itensCarrinhoDTO, Cliente cliente, List<Produto> produtos, List<Cor> cores) {
        this.cliente = cliente;
        this.itensCarrinho = new ArrayList<>();
        this.status = Status.ATIVO;

        for (int i = 0; i < itensCarrinhoDTO.size(); i++) {
            ItemCarrinhoDTO item = itensCarrinhoDTO.get(i);
            Produto produto = produtos.get(i);
            Cor cor = cores.get(i);
            this.itensCarrinho.add(item.createItemCarrinho(item, produto, cor, this));

            BigDecimal precoCusto = itensCarrinho.get(i).getProduto().getModelo().getPrecoCusto();
            Float lucro = (float) itensCarrinho.get(i).getProduto().getLucro();

            setValorTotal(precoCusto.add(BigDecimal.valueOf(lucro)).multiply(BigDecimal.valueOf(itensCarrinho.get(i).getQuantidade())));
        }
    }

    public void setValorTotal(BigDecimal valor) {
        this.valorTotal = this.valorTotal.add(valor);
        System.out.println(this.valorTotal);
    }
}
