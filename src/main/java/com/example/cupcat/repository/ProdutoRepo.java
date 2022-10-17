package com.example.cupcat.repository;

import com.example.cupcat.dto.ProdutoDTO;
import com.example.cupcat.model.Categoria;
import com.example.cupcat.model.Modelo;
import com.example.cupcat.model.Produto;
import com.example.cupcat.service.CategoriaService;
import com.example.cupcat.service.ICategoria;
import com.example.cupcat.service.IModelo;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepo {
    private final String linkFile = "src/main/resources/produto.json";
    private ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private ICategoria serviceCategoria;
    @Autowired
    private IModelo serviceModelo;

    public List<Produto> getAll(){
        try{
            return Arrays.asList(mapper.readValue(new File(linkFile), Produto[].class));
        } catch (Exception ex){
            System.out.println("Erro ao ler o arquivo");
        }

        return null;
    }

    public boolean saveProduto(ProdutoDTO produto, boolean create, int id){
        List<Produto> produtos = new ArrayList<>(getAll());
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        Produto novoProduto = new Produto(produto);

        if(create){
            novoProduto.setId(generateId());
            if(produtoAlreadyExists(novoProduto)) return false;

            novoProduto.setCategorias(getCategorias(produto.getCategorias()));
            novoProduto.setModelo(getModelo(produto.getModelo()));

            produtos.add(novoProduto);
        } else {
            produtos.set(id - 1, novoProduto);
        }

        try{
            writer.writeValue(new File(linkFile), produtos);

            return true;
        } catch (Exception ex){
            System.out.println("Erro ao salvar os dados!");
        }

        return false;
    }

    private boolean idAlreadyUsed(Produto produto){
        return getAll().size() >= produto.getId();
    }

    private boolean idAlreadyUsed(int id){
        return getAll().size() >= id;
    }

    private boolean produtoAlreadyExists(Produto novoProduto) {
        for (Produto produto : getAll()){
            if(produto.getNome().equals(novoProduto.getNome())) return true;
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

    private List<Categoria> getCategorias(List<Integer> idsCategorias){
        List<Categoria> categorias = new ArrayList<>();
        for(Integer idCategoria : idsCategorias){
            categorias.add(serviceCategoria.getCategoriaById(idCategoria).get());
        }

        return categorias;
    }

    private Modelo getModelo(int idModelo){
        return serviceModelo.getModeloById(idModelo).get();
    }
}
