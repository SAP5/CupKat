package com.example.cupcat.repository;

import com.example.cupcat.exception.NotFoundException;
import com.example.cupcat.model.Categoria;
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
public class CategoriaRepo {
    private final String linkFile = "src/main/resources/categoria.json";
    private ObjectMapper mapper = new ObjectMapper();

    public List<Categoria> getAll(){
        try{
            return Arrays.asList(mapper.readValue(new File(linkFile), Categoria[].class));
        } catch (Exception ex){
            System.out.println("Erro ao ler o arquivo");
        }

        return null;
    }

    public boolean saveCategoria(Categoria categoria, boolean create, int id){
        List<Categoria> categorias = new ArrayList<>(getAll());
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        if(create){
            categoria.setId(generateId());
            if(categoriaAlreadyExists(categoria)) return false;

            categorias.add(categoria);
        } else {
            categorias.set(id - 1, categoria);
        }

        try{
            writer.writeValue(new File(linkFile), categorias);

            return true;
        } catch (Exception ex){
            System.out.println("Erro ao salvar os dados!");
        }

        return false;
    }

    public Optional<Categoria> getCategoriaById(int id){
        if (!idAlreadyUsed(id)) throw new NotFoundException("Categoria não encontrada");

        return Optional.of(getAll().get(id - 1));
    }

    public boolean updateCategoria(Categoria categoria, int id){
        if(!idAlreadyUsed(categoria)) return false;
        return saveCategoria(categoria, false, id);
    }

    public Optional<Categoria> deleteCategoriaById(int id){
        if (!idAlreadyUsed(id)) throw new NotFoundException("Categoria não encontrada");

        Optional<Categoria> cliente = getCategoriaById(id);

        try{
            List<Categoria> categorias = new ArrayList<>(getAll());
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

            categorias.remove(id - 1);
            writer.writeValue(new File(linkFile), categorias);

            return cliente;
        } catch (Exception ex){
            System.out.println("Erro ao salvar os dados!");
        }

        return Optional.empty();
    }

    private boolean idAlreadyUsed(Categoria categoria){
        return getAll().size() >= categoria.getId();
    }

    private boolean idAlreadyUsed(int id){
        return getAll().size() >= id;
    }

    private boolean categoriaAlreadyExists(Categoria novaCategoria) {
        for (Categoria categoria : getAll()){
            if(categoria.getTitulo().equals(novaCategoria.getTitulo())) return true;
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
