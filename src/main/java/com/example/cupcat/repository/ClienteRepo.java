package com.example.cupcat.repository;

import com.example.cupcat.exception.NotFoundException;
import com.example.cupcat.model.Cliente;
import com.example.cupcat.util.ValidaCPF;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    public boolean saveCliente(Cliente cliente, boolean create, int id){
        List<Cliente> clientes = new ArrayList<>(getAll());
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        if(create){
            cliente.setId(generateId());
            if(clienteAlreadyExists(cliente)) return false;
            if(ValidaCPF.isCPF(cliente.getCpf())) return false;

            clientes.add(cliente);
        } else {
            cliente.setId(id);
            clientes.set(id - 1, cliente);
        }

        try{
            writer.writeValue(new File(linkFile), clientes);

            return true;
        } catch (Exception ex){
            System.out.println("Erro ao salvar os dados!");
        }

        return false;
    }

    public Optional<Cliente> getClienteById(int id){
        if (!idAlreadyUsed(id)) throw new NotFoundException("Cliente não encontrado");

        return Optional.of(getAll().get(id - 1));
    }

    public boolean updateCliente(Cliente cliente, int id){
        if(!idAlreadyUsed(cliente)) return false;
        return saveCliente(cliente, false, id);
    }

    public Optional<Cliente> deleteClienteById(int id){
        if (!idAlreadyUsed(id)) throw new NotFoundException("Cliente não encontrado");

        Optional<Cliente> cliente = getClienteById(id);

        try{
            List<Cliente> clientes = new ArrayList<>(getAll());
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

            clientes.remove(id - 1);
            writer.writeValue(new File(linkFile), clientes);

            return cliente;
        } catch (Exception ex){
            System.out.println("Erro ao salvar os dados!");
        }

        return Optional.empty();
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

    private boolean idAlreadyUsed(int id){
        return getAll().size() >= id;
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
            return getAll().get(getAll().size() - 1).getId() + 1;
        } catch (NullPointerException ex){
            return 1;
        }
    }
}
