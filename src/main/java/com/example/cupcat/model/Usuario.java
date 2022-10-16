package com.example.cupcat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends Model{
    @NotEmpty(message = "o nome não pode ser vazio")
    private String nome;
    @NotEmpty(message = "o email não pode ser vazio")
    @Email
    private String email;
    @NotEmpty(message = "A senha não pode estar vazia")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$*&@#])(?:([0-9a-zA-Z$*&@#])(?!\\1)){8,}$", message = "A senha é muito fraca")
    private String senha;
}
