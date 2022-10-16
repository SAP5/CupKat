package com.example.cupcat.repository;

import com.example.cupcat.exception.NotFoundException;
import com.example.cupcat.model.Categoria;
import com.example.cupcat.model.Modelo;
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
public class ModeloRepo {
    private final String linkFile = "src/main/resources/modelo.json";
    private ObjectMapper mapper = new ObjectMapper();

    public List<Modelo> getAll(){
        try{
            return Arrays.asList(mapper.readValue(new File(linkFile), Modelo[].class));
        } catch (Exception ex){
            System.out.println("Erro ao ler o arquivo");
        }

        return null;
    }

    public boolean saveModelo(Modelo modelo, boolean create, int id){
        List<Modelo> modelos = new ArrayList<>(getAll());
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        if(create){
            modelo.setId(generateId());
            if(modeloAlreadyExists(modelo)) return false;

            modelos.add(modelo);
        } else {
            modelos.set(id - 1, modelo);
        }

        try{
            writer.writeValue(new File(linkFile), modelos);

            return true;
        } catch (Exception ex){
            System.out.println("Erro ao salvar os dados!");
        }

        return false;
    }

    public Optional<Modelo> getModeloById(int id){
        if (!idAlreadyUsed(id)) throw new NotFoundException("Modelo não encontrado");

        return Optional.of(getAll().get(id - 1));
    }

    public boolean updateModelo(Modelo modelo, int id){
        if(!idAlreadyUsed(modelo)) return false;
        return saveModelo(modelo, false, id);
    }

    public Optional<Modelo> deleteModeloById(int id){
        if (!idAlreadyUsed(id)) throw new NotFoundException("Modelo não encontrado");

        Optional<Modelo> cliente = getModeloById(id);

        try{
            List<Modelo> modelos = new ArrayList<>(getAll());
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

            modelos.remove(id - 1);
            writer.writeValue(new File(linkFile), modelos);

            return cliente;
        } catch (Exception ex){
            System.out.println("Erro ao salvar os dados!");
        }

        return Optional.empty();
    }

    private boolean idAlreadyUsed(Modelo modelo){
        return getAll().size() >= modelo.getId();
    }

    private boolean idAlreadyUsed(int id){
        return getAll().size() >= id;
    }

    private boolean modeloAlreadyExists(Modelo novoModelo) {
        for (Modelo modelo : getAll()){
            if(modelo.getTitulo().equals(novoModelo.getTitulo())) return true;
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
