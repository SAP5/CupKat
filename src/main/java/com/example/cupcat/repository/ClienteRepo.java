package com.example.cupcat.repository;

import com.example.cupcat.model.Cliente;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Repository
public class ClienteRepo {
    private final String linkFile = "src/main/resources/cliente.json";
    private ObjectMapper mapper = new ObjectMapper();

    public List<Cliente> getAll(){
        try{
            return Arrays.asList(mapper.readValue(new File(linkFile), Cliente[].class));
        } catch (Exception ex){
            System.out.println("Erro ao ler o arquivo");
        }

        return null;
    }

    public boolean saveCliente(Cliente cliente){
        if(clienteAlreadyExists(cliente)) return false;

        List<Cliente> clientes = new ArrayList<>(getAll());
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        try{
            clientes.add(cliente);
            writer.writeValue(new File(linkFile), clientes);

            return true;
        } catch (Exception ex){
            System.out.println("Erro ao salvar os dados!");
        }

        return false;
    }

    public boolean clienteAlreadyExists(Cliente cliente){
        return idAlreadyUsed(cliente) || emailAlreadyUsed(cliente) || cpfAlreadyUsed(cliente);
    }

    private boolean idAlreadyUsed(Cliente cliente){
        return getAll().size() <= cliente.getId();
    }

    private boolean emailAlreadyUsed(Cliente novoCliente){
        for (Cliente cliente : getAll()) {
            if(cliente.getEmail().equals(novoCliente.getEmail())) return true;
        }

        return false;
    }

    private boolean cpfAlreadyUsed(Cliente novoCliente){
        for (Cliente cliente : getAll()){
            if(cliente.getCpf().equals(novoCliente.getCpf())) return true;
        }

        return false;
    }
}
