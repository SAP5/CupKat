package com.example.cupcat.enums;

import lombok.Getter;

@Getter
public enum Status {
    ATIVO(1),
    AGUARDANDO_PAGAMENTO(2),
    AGUARDANDO_APROVACAO(21),
    NAO_AUTORIZADO(22),
    PAGO(3),
    FABRICANDO(4),
    ENVIADO(5),
    ENTREGUE(6),
    INATIVO(7),
    CANCELADO(8),
    DELETADO(9);

    private final int valor;

    Status(int i) {
        this.valor = i;
    }
}
