package com.example.cupcat.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class Cliente extends Usuario{
    @NotEmpty(message = "O cpf não pode estar vazio")
    @Pattern(regexp = "^[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}", message = "O cpf está em um formato inválido")
    private String cpf;
}
