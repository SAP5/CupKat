package com.example.cupcat.dto;

import com.example.cupcat.model.Cliente;
import com.example.cupcat.model.Funcionario;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FuncionarioDTO extends ModelDTO implements Serializable {
    private String nome;

    public FuncionarioDTO(Funcionario funcionario){
        this.setId(funcionario.getId());
        this.setStatus(funcionario.getStatus());
        this.setNome(funcionario.getNome());
    }
}
