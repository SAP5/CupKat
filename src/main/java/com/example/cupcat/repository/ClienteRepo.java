package com.example.cupcat.repository;

import com.example.cupcat.model.Cliente;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        cliente.setId(generateId());
        if(clienteAlreadyExists(cliente)) return false;

        try{
            List<Cliente> clientes = new ArrayList<>(getAll());
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

            clientes.add(cliente);
            writer.writeValue(new File(linkFile), clientes);

            return true;
        } catch (Exception ex){
            System.out.println("Erro ao salvar os dados!");
        }

        return false;
    }

    public boolean clienteAlreadyExists(Cliente cliente){
        try{
            return idAlreadyUsed(cliente) || emailAlreadyUsed(cliente) || cpfAlreadyUsed(cliente);
        } catch (NullPointerException ex){
            return false;
        }
    }

    private boolean idAlreadyUsed(Cliente cliente){
        return getAll().size() >= cliente.getId();
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

    private int generateId(){
        try{
            return getAll().size() + 1;
        } catch (NullPointerException ex){
            return 1;
        }
    }
}
