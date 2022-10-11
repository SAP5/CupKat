package com.example.cupcat.repository;

import com.example.cupcat.model.Cliente;
import com.example.cupcat.model.Funcionario;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class FuncionarioRepo {
    private final String linkFile = "src/main/resources/funcionario.json";
    private ObjectMapper mapper = new ObjectMapper();

    public List<Funcionario> getAll(){
        try{
            return Arrays.asList(mapper.readValue(new File(linkFile), Funcionario[].class));
        } catch (Exception ex){
            System.out.println("Erro ao ler o arquivo");
        }

        return null;
    }

    public boolean saveFuncionario(Funcionario funcionario){
        if(funcionarioAlreadyExists(funcionario)) return false;

        List<Funcionario> funcionarios = new ArrayList<>(getAll());
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        try{
            funcionarios.add(funcionario);
            writer.writeValue(new File(linkFile), funcionarios);

            return true;
        } catch (Exception ex){
            System.out.println("Erro ao salvar os dados!");
        }

        return false;
    }

    public boolean funcionarioAlreadyExists(Funcionario funcionario){
        return getAll().contains(funcionario) ||
                getAll().get(funcionario.getId() - 1).getEmail().equals(funcionario.getEmail());
    }
}
