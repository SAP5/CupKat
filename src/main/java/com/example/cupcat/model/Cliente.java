package com.example.cupcat.model;

import com.example.cupcat.dto.ClienteDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente implements Serializable {
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
    @NotEmpty(message = "o nome não pode ser vazio")
    @Column(nullable = false)
    private String nome;

    @NotEmpty(message = "o email não pode ser vazio")
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotEmpty(message = "A senha não pode estar vazia")
    //@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$*&@#])(?:([0-9a-zA-Z$*&@#])(?!\\1)){8,}$", message = "A senha é muito fraca")
    @Column(nullable = false)
    private String senha;

    @NotEmpty(message = "O cpf não pode estar vazio")
    @Pattern(regexp = "^[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}", message = "O cpf está em um formato inválido")
    @Column(unique = true)
    private String cpf;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnoreProperties("cliente")
    @JsonManagedReference
    @ToString.Exclude
    private List<Carrinho> carrinhos;

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public Cliente(ClienteDTO clienteDTO) {
        this.id = clienteDTO.getId();
        this.nome = clienteDTO.getNome();
        this.email = clienteDTO.getEmail();
        this.senha = clienteDTO.getSenha();
        this.cpf = clienteDTO.getCpf();
    }
}
