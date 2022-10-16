package com.example.cupcat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends Model{
    @NotEmpty
    private String nome;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String senha;
}
