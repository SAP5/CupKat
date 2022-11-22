package com.example.cupcat.dto;

import com.example.cupcat.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDTO extends ModelDTO implements Serializable {
    private String cpf;
    private String nome;
    private String email;
    private String senha;

    public ClienteDTO(Cliente cliente){
        this.setId(cliente.getId());
        this.setStatus(cliente.getStatus());
        this.setCpf(cliente.getCpf());
        this.setNome(cliente.getNome());
        this.setEmail(cliente.getEmail());
        this.setSenha(cliente.getSenha());
    }
}
