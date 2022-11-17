package com.example.cupcat.dto;

import com.example.cupcat.model.Carrinho;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarrinhoDTO {
    private int cliente;
    private List<ItemCarrinhoDTO> itensCarrinho;
}
