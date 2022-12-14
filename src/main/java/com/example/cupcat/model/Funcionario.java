package com.example.cupcat.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Funcionario implements Serializable {
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

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
